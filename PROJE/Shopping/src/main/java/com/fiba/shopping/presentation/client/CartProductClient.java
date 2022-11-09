package com.fiba.shopping.presentation.client;

import com.fiba.shopping.business.dto.CartProductDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartProductClient {

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
