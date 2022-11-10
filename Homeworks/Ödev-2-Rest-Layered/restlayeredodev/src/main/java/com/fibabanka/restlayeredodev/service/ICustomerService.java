package com.fibabanka.restlayeredodev.service;

import com.fibabanka.restlayeredodev.model.Customer;
import org.springframework.stereotype.Service;


public interface ICustomerService {

    Customer find(long customerId);

    Customer[] findAll();

    public Customer createCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(long customerId);
}
