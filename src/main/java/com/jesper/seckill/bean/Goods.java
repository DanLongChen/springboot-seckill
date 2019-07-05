package com.jesper.seckill.bean;

/**
 * Created by DanLongChen on 2019/5/22.
 * 表示所有的商品，包括商品信息，总的库存等
 */
public class Goods {
    /**
     * 商品的ID号
     */
    private Long id;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品的标题
     */
    private String goodsTitle;
    /**
     * 商品图片地址
     */
    private String goodsImg;
    /**
     * 商品详情
     */
    private String goodsDetail;
    /**
     * 商品价格
     */
    private Double goodsPrice;
    /**
     * 存货
     */
    private Integer goodsStock;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public String getGoodsTitle() {
        return goodsTitle;
    }
    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }
    public String getGoodsImg() {
        return goodsImg;
    }
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
    public String getGoodsDetail() {
        return goodsDetail;
    }
    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
    public Double getGoodsPrice() {
        return goodsPrice;
    }
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public Integer getGoodsStock() {
        return goodsStock;
    }
    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }
}
