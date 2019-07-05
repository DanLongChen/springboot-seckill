package com.jesper.seckill.vo;

import com.jesper.seckill.bean.User;

/**
 * Created by DanLongChen on 2019/5/24.
 */
public class GoodsDetailVo {
    private int seckillStatus = 0;//秒杀的状态
    private int remainSeconds = 0;//剩余时间
    private GoodsVo goods ;
    private User user;

    public int getSeckillStatus() {
        return seckillStatus;
    }

    public void setSeckillStatus(int seckillStatus) {
        this.seckillStatus = seckillStatus;
    }

    public int getRemainSeconds() {
        return remainSeconds;
    }

    public void setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }

    public GoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
