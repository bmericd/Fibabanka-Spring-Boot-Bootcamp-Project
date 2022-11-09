package com.fibabanka.spring.service;

import com.fibabanka.spring.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    public Product find(long productId){
        Product product = new Product(productId,"Cep Telefonu",1450);
        return product;
    }

    @Override
    public Iterable<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(301, "Cep Telefonu",1450));
        productList.add(new Product(302, "Dizüstü Bilgisayar",6575));
        productList.add(new Product(303, "Masaüstü Bilgisayar",3490));
        return productList;
    }

    @Override
    public void createProduct(Product product) {
        System.out.println("Ürün eklendi "+ product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());

    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("Ürün değişti" + product.getProductName());

    }

    @Override
    public void deleteProduct(long productId) {
        System.out.println("Ürün silindi "+ productId);

    }


}
