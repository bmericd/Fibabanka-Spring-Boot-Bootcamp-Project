package com.fibabanka.spring.resource;

import com.fibabanka.spring.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusResource {

    @GetMapping("/status/ok/{id}")
    public ResponseEntity<?> getOk(@PathVariable("id")long productId){
        Product product = new Product(productId,"Cep Telefonu",1450);
        return ResponseEntity.ok(product);
        //return new ResponseEntity<>(product, HttpStatus.OK);
        //return ResponseEntity.ok().body(product);
    }

    @GetMapping("/status/notfound/{id}")
    public ResponseEntity<?> getNotFound(@PathVariable("id")long productId){
      if (productId ==0){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ürün bulunamadı");
      }
        Product product = new Product(productId,"Cep Telefonu",1450);
        return ResponseEntity.ok(product);
    }
}
