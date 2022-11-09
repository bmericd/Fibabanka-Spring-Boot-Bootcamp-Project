package com.fiba.shopping.business.service;

import com.fiba.shopping.business.dto.CartProductDto;
import com.fiba.shopping.data.entity.CartProduct;
import org.springframework.data.repository.CrudRepository;

public interface CartProductService{
    String addProduct(CartProductDto cartProductDto);

    String removeProductFromCart(long cartId, long productId);

}
