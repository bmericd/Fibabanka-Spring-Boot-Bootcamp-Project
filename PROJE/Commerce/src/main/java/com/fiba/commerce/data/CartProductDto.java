package com.fiba.commerce.data;

public class CartProductDto {

    private long cartProductId;
    private long productId;
    private long salesQuantity;
    private double salesPrice;
    private double lineAmount;
    private long cartId;

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public CartProductDto() {
    }


    public CartProductDto(long productId, long salesQuantity, long cartId) {
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.cartId = cartId;
    }

    public CartProductDto(long cartProductId, long productId, long salesQuantity, long cartId) {
        this.cartProductId = cartProductId;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.cartId = cartId;
    }

    public CartProductDto(long cartProductId, long productId, long salesQuantity, double salesPrice, double lineAmount) {
        this.cartProductId = cartProductId;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
        this.lineAmount = lineAmount;
    }

    public CartProductDto(long productId, long salesQuantity, double salesPrice, double lineAmount, long cartId) {
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
        this.lineAmount = lineAmount;
        this.cartId = cartId;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(long salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(double lineAmount) {
        this.lineAmount = lineAmount;
    }
}
