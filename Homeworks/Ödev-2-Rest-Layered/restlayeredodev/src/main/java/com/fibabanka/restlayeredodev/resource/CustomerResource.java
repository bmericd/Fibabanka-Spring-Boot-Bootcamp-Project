package com.fibabanka.restlayeredodev.resource;

import com.fibabanka.restlayeredodev.model.Customer;
import com.fibabanka.restlayeredodev.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerResource {


    private ICustomerService customerService;

    public CustomerResource(ICustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/api/customer/{id}")
    public Customer getCustomer(@PathVariable("id") long customerId)
    {
        return customerService.find(customerId);
    }

    @GetMapping("/api/customer/get/all")
    public Customer[] getAllCustomers()
    {
        return  customerService.findAll();
    }

    @PostMapping("/api/customer")
    public Customer postCustomer(@RequestBody Customer customer){
        Customer response = customerService.createCustomer(customer);
        return response;
    }

    @PutMapping("/api/customer")
    public void putCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/api/customer/{id}")
    public void deleteCustomer(@PathVariable("id") long customerId){
        customerService.deleteCustomer(customerId);
    }
}
