package com.fiba.commerce.client;

import com.fiba.commerce.data.CartDto;
import com.fiba.commerce.data.CartProductDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class ShoppingClient {

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

    public String addProductToCart(CartProductDto cartProductDto){
        String url = "http://localhost:8082/api/shopping/cart/add";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url,cartProductDto, String.class);
        return response;
    }

    public String removeProductFromCart(long cartId, long productId){
        String url = "http://localhost:8082/api/shopping/cart/remove/"+cartId+"/"+productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url, String.class);
        return "Deleted the product from the cart.";
    }
}
