package com.fiba.shopping.presentation.rest;

import com.fiba.shopping.business.dto.CartProductDto;
import com.fiba.shopping.business.service.CartProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartProductResource {

    private CartProductService cartProductService;

    public CartProductResource(CartProductService cartProductService){
        this.cartProductService = cartProductService;
    }

    @PostMapping("/api/shopping/cart/add")
    public String addProductToCart(@RequestBody CartProductDto cartProductDto){
        String response = cartProductService.addProduct(cartProductDto);
        return response;
    }

    @DeleteMapping("/api/shopping/cart/remove/{cartId}/{productId}")
    public String removeProductFromCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId){
        String response = cartProductService.removeProductFromCart(cartId,productId);
        return response;
    }
}
