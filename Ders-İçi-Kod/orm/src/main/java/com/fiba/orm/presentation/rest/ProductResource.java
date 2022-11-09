package com.fiba.orm.presentation.rest;

import com.fiba.orm.business.dto.ProductDto;
import com.fiba.orm.business.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResource {

   private ProductService productService;

   public ProductResource(ProductService productService){
      this.productService = productService;
   }

   @GetMapping("/api/product/{id}")
   public ProductDto getProduct(@PathVariable("id")long productId){
      ProductDto product = productService.find(productId);
      return product;
   }

   @GetMapping("/api/products")
   public List<ProductDto> getProducts(){
        /*
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(301, "Cep Telefonu",1450));
        productList.add(new Product(302, "Dizüstü Bilgisayar",6575));
        productList.add(new Product(303, "Masaüstü Bilgisayar",3490));
        */
      return (List<ProductDto>) productService.findAll();
   }

   @PostMapping("/api/product")
   public void postProduct(@RequestBody ProductDto product){
      //System.out.println("Ürün eklendi "+ product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
      productService.create(product);
   }

   @PutMapping("/api/product")
   public void putProduct(@RequestBody ProductDto product){
      //System.out.println("Ürün değişti" + product.getProductName());
      productService.update(product);
   }

   @DeleteMapping("/api/product/{id}")
   public void deleteProduct(@PathVariable("id")long productId){
        /*
        Product product = new Product(productId,"Cep Telefonu",1450);
        return product;
         */
      productService.delete(productId);
   }
}
