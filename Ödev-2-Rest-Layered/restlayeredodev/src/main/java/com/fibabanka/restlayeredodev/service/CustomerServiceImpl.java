package com.fibabanka.restlayeredodev.service;

import com.fibabanka.restlayeredodev.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Override
    public Customer find(long customerId) {
        Customer customer = new Customer(customerId,"Meriç",1000); //Dummy Data
        return customer;
    }

    @Override
    public Customer[] findAll() {
        Customer[] customers = new Customer[3];
        customers[0] = new Customer(1,"Meriç",1000);
        customers[1] = new Customer(2,"Osman",1200);
        customers[2] = new Customer(3,"Gizem",1500);

        return customers;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer newCustomer = customer;
        return newCustomer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        //Update DB
        System.out.println("Updated " + customer.getCustomerName());
    }

    @Override
    public void deleteCustomer(long customerId) {
        System.out.println("Deleted " + customerId);
    }
}
