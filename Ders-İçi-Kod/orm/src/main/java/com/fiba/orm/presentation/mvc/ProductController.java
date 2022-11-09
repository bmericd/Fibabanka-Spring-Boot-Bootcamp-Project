package com.fiba.orm.presentation.mvc;

import com.fiba.orm.business.service.ProductService;
import com.fiba.orm.data.entity.Product;
import com.fiba.orm.data.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/inventory")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/product/insert")
    @ResponseBody
    public String insertProduct(){
        Product product = new Product();
        product.setProductName("Cep Telefonu");
        product.setSalesPrice(3250);
        productRepository.save(product);
        return  "Sokuldu :" + product.getProductId();
    }
    @GetMapping("/product/find/{id}")
    @ResponseBody
    public String findProduct(@PathVariable("id") long productId){
        Optional<Product> optional = productRepository.findById(productId);
        if(optional.isPresent()){
            Product product = optional.get();
            return "Ürün bulundu: "+ product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice();
        }
        return "Ürün bulunamadı";
    }

    @GetMapping("/product/list")
    @ResponseBody
    public List<Product> listProducts(){
        Iterable<Product> products = productRepository.findAll();
        return (List<Product>) products;
    }

    @GetMapping("/product/expensive/{min}")
    @ResponseBody
    public List<Product> listExpensiveProducts(@PathVariable("min") double min){
        Iterable<Product> products = productRepository.findAllBySalesPriceMin(min);
        return (List<Product>) products;
    }

    @GetMapping("/product/delete/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable("id") long productId){
        if(!productRepository.existsById(productId)){
            return "Bulunamadı : "+ productId;
        }
        productRepository.deleteById(productId);
        return "Ürün silindi : " + productId;
    }
}
