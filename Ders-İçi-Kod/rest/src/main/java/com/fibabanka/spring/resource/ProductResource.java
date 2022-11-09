package com.fibabanka.spring.resource;

import com.fibabanka.spring.Product;
import com.fibabanka.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductResource {

   //@Autowired
    private ProductService productService;

    public ProductResource(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/api/product/{id}")
    public Product getProduct(@PathVariable("id")long productId){
        Product product = productService.find(productId);
        return product;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts(){
        /*
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(301, "Cep Telefonu",1450));
        productList.add(new Product(302, "Dizüstü Bilgisayar",6575));
        productList.add(new Product(303, "Masaüstü Bilgisayar",3490));
        */
        return (List<Product>) productService.findAll();
    }

    @PostMapping("/api/product")
    public void postProduct(@RequestBody Product product){
        //System.out.println("Ürün eklendi "+ product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
        productService.createProduct(product);
    }

    @PutMapping("/api/product")
    public void putProduct(@RequestBody Product product){
        //System.out.println("Ürün değişti" + product.getProductName());
        productService.updateProduct(product);
    }

    @DeleteMapping("/api/product/{id}")
    public void deleteProduct(@PathVariable("id")long productId){
        /*
        Product product = new Product(productId,"Cep Telefonu",1450);
        return product;
         */
        productService.deleteProduct(productId);
    }

}
