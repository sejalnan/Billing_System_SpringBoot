package com.spring.billingsoftware.Interface;

import com.spring.billingsoftware.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer addCustomer(Customer customer);
    public Customer updateCustomerDetails(String id,Customer customer);
    public List<Customer> getAllCustomers();
    public Customer getCustomerById(String id);
}
