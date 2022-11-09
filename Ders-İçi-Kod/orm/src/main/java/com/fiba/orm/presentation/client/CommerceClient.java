package com.fiba.orm.presentation.client;

import com.fiba.orm.business.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CommerceClient {

    @Autowired
    private ProductClient productClient;

    public CommerceClient(ProductClient productClient){
        this.productClient= productClient;
    }

    //FOR TESTING
    @GetMapping("/product/get")
    @ResponseBody
    public String getProduct(){
        long productId = 3;
        /*
        String url = "http://localhost:8080/api/product/"+productId;
        RestTemplate restTemplate = new RestTemplate();
        ProductDto product = restTemplate.getForObject(url,ProductDto.class);
         */
        ProductDto product = productClient.getProduct(productId);

        System.out.println("Ürün:" +product.getProductName());
        return "İşlem başarılı";
    }

}
