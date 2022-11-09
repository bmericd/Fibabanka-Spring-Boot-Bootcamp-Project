package com.fiba.shopping.presentation.client;

import com.fiba.shopping.business.dto.CartDto;
import com.fiba.shopping.business.dto.CartProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommerceClient {

    private CartClient cartClient;
    private CartProductClient cartProductClient;

    public  CommerceClient(CartClient cartClient, CartProductClient cartProductClient){
        this.cartClient = cartClient;
        this.cartProductClient = cartProductClient;
    }

    @GetMapping("/shopping/cart/create")
    @ResponseBody
    public long createCart(){
        long cartId = cartClient.createCart();
        return  cartId;
    }

    @PostMapping("/shopping/cart/add")
    @ResponseBody
    public String addProductToCart(@RequestBody CartProductDto cartProductDto){
        String response = cartProductClient.addProductToCart(cartProductDto);
        return  response;
    }

    @DeleteMapping("/shopping/cart/remove/{cartId}/{productId}")
    @ResponseBody
    public String removeProductFromCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId){
        String response = cartProductClient.removeProductFromCart(cartId,productId);
        return response;
    }

    @PutMapping("/shopping/checkout/{cartId}")
    @ResponseBody
    public String checkoutCart(@PathVariable("cartId") long cartId){
        String response = cartClient.checkoutCart(cartId);
        return response;
    }

    @GetMapping("/shopping/cart/find/{cartId}")
    @ResponseBody
    public CartDto findCart(@PathVariable("cartId") long cartId){
        CartDto response = cartClient.findCart(cartId);
        return response;
    }
}
