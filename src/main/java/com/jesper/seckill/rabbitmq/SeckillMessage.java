package com.jesper.seckill.rabbitmq;

import com.jesper.seckill.bean.User;

/**
 * Created by DanLongChen on 2019/5/29.
 *
 * 秒杀的消息体（发送到rabbitmq上）
 */
public class SeckillMessage {

    private User user;
    private long goodsId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }
}
