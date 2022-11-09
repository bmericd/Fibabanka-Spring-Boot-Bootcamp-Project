package com.fiba.shopping.presentation.rest;

import com.fiba.shopping.business.dto.CartDto;
import com.fiba.shopping.business.service.CartService;
import com.fiba.shopping.data.repository.CartRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartResource {

    private CartService cartService;

    public CartResource(CartService cartService){
        this.cartService= cartService;
    }

    @GetMapping("/api/shopping/cart/create")
    public long createCart(){
        long cartId = cartService.create();
        return cartId;
    }

    @PutMapping("/api/shopping/checkout/{cartId}")
    public String checkoutCart(@PathVariable("cartId") long cartId){
        String response = cartService.checkout(cartId);
        return response;
    }

    @GetMapping("/api/shopping/cart/find/{cartId}")
    public CartDto findCart(@PathVariable("cartId") long cartId){
        CartDto response = cartService.find(cartId);
        return response;
    }
}
