package com.fibabanka.spring.client;

import com.fibabanka.spring.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProductController {

    @GetMapping("/product/get")
    @ResponseBody
    public String getProduct(){
        long productId = 301;
        String url = "http://localhost:8080/api/product/"+productId;
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(url,Product.class);
        System.out.println("Ürün:" +product.getProductName());
        return "İşlem başarılı";
    }

    @GetMapping("/product/post")
    @ResponseBody
    public String postProduct(){
        Product product = new Product(304,"Fritöz",540);
        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url,product,Product.class);
        System.out.println("Ürün:" +product.getProductName());
        return "Yollama başarılı";
    }

    @GetMapping("/product/put")
    @ResponseBody
    public String putProduct(){
        Product product = new Product(302,"Tablet Bilgisayar",5465);
        String url = "http://localhost:8080/api/product";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Product>(product),Void.class);
        return "Koyma başarılı";
    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct(){
        long productId = 303;
        String url = "http://localhost:8080/api/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url,Product.class);
        return "Silme başarılı";
    }

}
