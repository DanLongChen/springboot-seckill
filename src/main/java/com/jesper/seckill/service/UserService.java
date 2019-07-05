package com.jesper.seckill.service;

import com.alibaba.druid.util.StringUtils;
import com.jesper.seckill.bean.User;
import com.jesper.seckill.exception.GlobalException;
import com.jesper.seckill.mapper.UserMapper;
import com.jesper.seckill.redis.RedisService;
import com.jesper.seckill.redis.UserKey;
import com.jesper.seckill.result.CodeMsg;
import com.jesper.seckill.util.MD5Util;
import com.jesper.seckill.util.UUIDUtil;
import com.jesper.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DanLongChen on 2019/5/22.
 *
 * 实现用户登录的控制逻辑
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;//用于操作持久层

    @Autowired
    RedisService redisService;//用于操作redis

    public static final String COOKIE_NAME_TOKEN = "token";

    public User getById(long id) {
        //对象缓存
        User user = redisService.get(UserKey.getById, "" + id, User.class);//从缓存（String中，bean的话是json）重建bean
        if (user != null) {
            return user;
        }
        /**
         * 若在缓存中找不到，则先去数据库查询，查询到之后在存入缓存
         */
        user = userMapper.getById(id);
        if (user != null) {
            redisService.set(UserKey.getById, "" + id, user);//把bean转化为String（基本类型直接转，bean的话转化为json）
        }
        return user;
    }

    /**
     * 典型缓存同步场景：更新密码（这里需要更正一下，应该是更新数据库的时候直接使缓存失效就可以了，不需要再更新缓存）
     */
    public boolean updatePassword(String token, long id, String formPass) {
        //取user
        User user = getById(id);
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //使缓存失效（懒加载思想）
        redisService.delete(UserKey.getById, ""+id);
        //更新数据库
        User toBeUpdate = new User();
        toBeUpdate.setId(id);
        toBeUpdate.setPassword(MD5Util.formPassToDBPass(formPass, user.getSalt()));
        userMapper.update(toBeUpdate);
//        //更新缓存：先删除再插入
//        redisService.delete(UserKey.getById, ""+id);
//        user.setPassword(toBeUpdate.getPassword());
//        redisService.set(UserKey.token, token, user);
        return true;
    }

    public String login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        /**
         * 通过手机号获取用户（也就是判断用户是否存在）
         */
        User user = getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        /**
         * 密码验证，也就是将用户的密码进行编码之后和数据库中的密码进行验证
         */
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        /**
         * 生成token，加入cookie再返回给客户端
         */
        String token = UUIDUtil.uuid();
        addCookie(response, token, user);
        return token;
    }

    /**
     * 将token做为key，用户信息做为value 存入redis模拟session
     * 同时将token存入cookie，保存登录状态
     */
    public void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }

    /**
     * 根据token获取用户信息
     */
    public User getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisService.get(UserKey.token, token, User.class);
        //延长有效期，有效期等于最后一次操作+有效期
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }

}
