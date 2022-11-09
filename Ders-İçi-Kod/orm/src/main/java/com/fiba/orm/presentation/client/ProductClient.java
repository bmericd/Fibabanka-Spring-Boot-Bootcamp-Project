package com.fiba.orm.presentation.client;

import com.fiba.orm.business.dto.ProductDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component //normalde controller
public class ProductClient {

    //FOR TESTING
    //@GetMapping("/product/get")
    //@ResponseBody
    public ProductDto getProduct(long productId){ //normalde parametresiz
        //long productId = 301;
        String url = "http://localhost:8080/api/product/"+productId;
        RestTemplate restTemplate = new RestTemplate();
        ProductDto product = restTemplate.getForObject(url,ProductDto.class);
        System.out.println("Ürün:" +product.getProductName());
        return product;
    }

    @GetMapping("/product/post")
    @ResponseBody
    public String postProduct(){
        ProductDto product = new ProductDto(304,"Fritöz",540);
        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url,product,ProductDto.class);
        System.out.println("Ürün:" +product.getProductName());
        return "Yollama başarılı";
    }

    @GetMapping("/product/put")
    @ResponseBody
    public String putProduct(){
        ProductDto product = new ProductDto(302,"Tablet Bilgisayar",5465);
        String url = "http://localhost:8080/api/product";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<ProductDto>(product),Void.class);
        return "Koyma başarılı";
    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct(){
        long productId = 303;
        String url = "http://localhost:8080/api/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url,ProductDto.class);
        return "Silme başarılı";
    }
}
