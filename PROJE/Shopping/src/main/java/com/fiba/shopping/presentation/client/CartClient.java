package com.fiba.shopping.presentation.client;

import com.fiba.shopping.business.dto.CartDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartClient {

    public long createCart(){
        String url = "http://localhost:8082/api/shopping/cart/create";
        RestTemplate restTemplate = new RestTemplate();
        long cartId = restTemplate.getForObject(url, Long.class);
        return cartId;
    }

    public String checkoutCart(long cartId){
        String url = "http://localhost:8082/api/shopping/checkout/"+cartId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url, String.class);
        return "Checkout has been made";
    }

    public CartDto findCart(long cartId){
        String url = "http://localhost:8082/api/shopping/cart/find/"+cartId;
        RestTemplate restTemplate = new RestTemplate();
        CartDto response = restTemplate.getForObject(url, CartDto.class);
        return response;
    }


}
