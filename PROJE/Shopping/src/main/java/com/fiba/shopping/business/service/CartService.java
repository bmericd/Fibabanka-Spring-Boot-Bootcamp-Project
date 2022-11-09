package com.fiba.shopping.business.service;

import com.fiba.shopping.business.dto.CartDto;
import com.fiba.shopping.data.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartService{
    long create();
    String checkout(long cartId);
    CartDto find(long cartId);
}
