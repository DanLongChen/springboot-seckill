package com.jesper.seckill.bean;

import java.util.Date;

/**
 * Created by DanLongChen on 2018/5/22.
 */
public class OrderInfo {
    /**
     * 订单的ID
     */
    private Long id;
    private Long userId;//用户ID
    private Long goodsId;//商品ID
    private Long  deliveryAddrId;//交货地址
    private String goodsName;//商品名称
    private Integer goodsCount;//商品数量
    private Double goodsPrice;//商品价格
    private Integer orderChannel;//订单的通道(1:在线，2：安卓，3：IOS)
    private Integer status;//状态
    private Date createDate;//创建时间
    private Date payDate;//支付时间
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
    public Long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    public Long getDeliveryAddrId() {
        return deliveryAddrId;
    }
    public void setDeliveryAddrId(Long deliveryAddrId) {
        this.deliveryAddrId = deliveryAddrId;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public Integer getGoodsCount() {
        return goodsCount;
    }
    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
    public Double getGoodsPrice() {
        return goodsPrice;
    }
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public Integer getOrderChannel() {
        return orderChannel;
    }
    public void setOrderChannel(Integer orderChannel) {
        this.orderChannel = orderChannel;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}
