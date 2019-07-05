package com.jesper.seckill.redis;

/**
 * Created by DanLongChen on 2019/5/21.
 */
public class UserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600*2;//默认2个小时

    /**
     * 防止被外面实例化
     */
    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 需要缓存的字段
     */
    public static UserKey token = new UserKey(TOKEN_EXPIRE,"token");//token默认两个小时
    public static UserKey getById = new UserKey(0, "id");//id设置为一直存在

}
