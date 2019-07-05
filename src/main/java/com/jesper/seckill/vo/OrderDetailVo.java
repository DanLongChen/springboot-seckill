package com.jesper.seckill.vo;

import com.jesper.seckill.bean.OrderInfo;

/**
 * Created by DanLongChen on 2019/5/28.
 *
 * 用于将商品的信息进一步包装
 */
public class OrderDetailVo {
    private GoodsVo goods;//秒杀的详细信息
    private OrderInfo order;//订单详情
    public GoodsVo getGoods() {
        return goods;
    }
    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }
    public OrderInfo getOrder() {
        return order;
    }
    public void setOrder(OrderInfo order) {
        this.order = order;
    }
}
