package com.jesper.seckill.bean;

import java.util.Date;

/**
 * Created by DanLongChen on 2019/5/22.
 * 表示用于秒杀的商品
 */
public class SeckillGoods {
    /**
     * 秒杀商品ID
     */
    private Long id;
    /**
     * 对应的商品ID
     */
    private Long goodsId;
    /**
     * 库存
     */
    private Integer stockCount;
    /**
     * 开始，结束时间
     */
    private Date startDate;
    private Date endDate;
    /**
     * 版本
     */
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
