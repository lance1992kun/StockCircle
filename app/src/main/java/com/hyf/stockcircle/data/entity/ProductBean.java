package com.hyf.stockcircle.data.entity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/12 13:01
 *   desc    : 商品详情实体类
 *   version : 1.0
 * </pre>
 */

public class ProductBean {
    /**
     * 点击量
     */
    private int clickNum;
    /**
     * 创建日期
     */
    private long createDate;
    /**
     * 商品唯一id
     */
    private int id;
    /**
     * 是否上下架
     */
    private boolean isShow;
    /**
     * 客服QQ
     */
    private String kefuClient;
    /**
     * 客服名称
     */
    private String kefuName;
    /**
     * 描述
     */
    private String memo;
    /**
     * 修改日期
     */
    private long modifyDate;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品原价
     */
    private int price;
    /**
     * 商品图片
     */
    private String proImageSrc;
    /**
     * 销售量
     */
    private int sellNum;
    /**
     * 商品销售价
     */
    private int sellPrice;
    /**
     * 商品类型
     */
    private String type;

    public int getClickNum() {
        return clickNum;
    }

    public void setClickNum(int clickNum) {
        this.clickNum = clickNum;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getKefuClient() {
        return kefuClient;
    }

    public void setKefuClient(String kefuClient) {
        this.kefuClient = kefuClient;
    }

    public String getKefuName() {
        return kefuName;
    }

    public void setKefuName(String kefuName) {
        this.kefuName = kefuName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProImageSrc() {
        return proImageSrc;
    }

    public void setProImageSrc(String proImageSrc) {
        this.proImageSrc = proImageSrc;
    }

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
