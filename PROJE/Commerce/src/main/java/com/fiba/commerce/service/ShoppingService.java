package com.fiba.commerce.service;

import com.fiba.commerce.data.CartDto;
import com.fiba.commerce.data.CartProductDto;

public interface ShoppingService {

    long createCart();
    String checkoutCart(long cartId);
    CartDto findCart(long cartId);
    String addProductToCart(CartProductDto cartProductDto);
    String removeProductFromCart(long cartId, long productId);
}
