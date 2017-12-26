package com.zxzd.im.data.entity;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/12 13:07
 *   desc    : 商品详情
 *   version : 1.0
 * </pre>
 */

public class ProductDetailBean extends BaseBean {
    /**
     * 商品
     */
    private ProductBean product;

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }
}
