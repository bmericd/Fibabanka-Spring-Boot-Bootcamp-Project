package com.fiba.commerce.data;

import java.util.List;

public class CartDto {

    private long cartId;
    private String customerName;
    private List<CartProductDto> cartProductDtoList;
    private double totalAmount;
    private boolean cartStatus;

    public CartDto() {
    }

    public CartDto(long cartId, String customerName, List<CartProductDto> cartProductDtoList, double totalAmount, boolean cartStatus) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.cartProductDtoList = cartProductDtoList;
        this.totalAmount = totalAmount;
        this.cartStatus = cartStatus;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<CartProductDto> getCartProductDtoList() {
        return cartProductDtoList;
    }

    public void setCartProductDtoList(List<CartProductDto> cartProductDtoList) {
        this.cartProductDtoList = cartProductDtoList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(boolean cartStatus) {
        this.cartStatus = cartStatus;
    }
}
