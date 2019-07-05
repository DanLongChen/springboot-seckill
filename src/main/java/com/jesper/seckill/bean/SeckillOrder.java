package com.jesper.seckill.bean;

/**
 * Created by DanLongChen on 2019/5/22.
 * //秒杀的订单
 */
public class SeckillOrder {
    private Long id;
    private Long userId;//对应于的用户id
    private Long  orderId;//对应于的订单id
    private Long goodsId;//对应于的商品id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
