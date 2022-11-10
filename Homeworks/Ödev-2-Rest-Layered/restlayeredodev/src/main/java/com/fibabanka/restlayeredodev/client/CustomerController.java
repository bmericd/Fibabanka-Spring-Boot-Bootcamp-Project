package com.fibabanka.restlayeredodev.client;

import com.fibabanka.restlayeredodev.model.Customer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class CustomerController {

    @GetMapping("/customer/get/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable("id") long customerId){
        String url = "http://localhost:8080/api/customer/"+customerId;
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(url,Customer.class);
        return customer;
    }

    @GetMapping("/customer/get/all")
    @ResponseBody
    public List<Customer> getAllCustomers(){
        String url = "http://localhost:8080/api/customer/get/all";
        RestTemplate restTemplate = new RestTemplate();
        Customer[] customerArray = restTemplate.getForObject(url,Customer[].class);
        List<Customer> customerList = Arrays.asList(customerArray);
        return customerList;
    }

    @GetMapping("/customer/post")
    @ResponseBody
    public String postCustomer(@RequestBody Customer customer){
        String url = "http://localhost:8080/api/customer/";
        RestTemplate restTemplate = new RestTemplate();
        Customer response = restTemplate.postForObject(url,customer,Customer.class);
        return "İşlem Başarılı!  Customer : " + response.getCustomerName() + " oluşturuldu!";
    }

    @GetMapping("/customer/put")
    @ResponseBody
    public String putCustomer(@RequestBody Customer customer){
        String url = "http://localhost:8080/api/customer/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.PUT,new HttpEntity<Customer>(customer),Void.class);
        return "Koyma Başarılı!";
    }

    @GetMapping("/customer/delete/{id}")
    @ResponseBody
    public String deleteCustomer(@PathVariable("id") long customerId){
        String url = "http://localhost:8080/api/customer/"+customerId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url, Customer.class);
        return "Silme Başarılı!";
    }
}
