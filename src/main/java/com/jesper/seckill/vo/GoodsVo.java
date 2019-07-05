package com.jesper.seckill.vo;

import com.jesper.seckill.bean.Goods;

import java.util.Date;

/**
 * Created by DanLongChen on 2019/5/22.
 * 商品详情信息
 */
public class GoodsVo extends Goods {
    private Double seckillPrice;//秒杀的价格
    private Integer stockCount;//余量
    private Date startDate;//开始时间
    private Date endDate;//结束时间
    private Integer version;//并发级别

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

    public Double getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Double seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}

