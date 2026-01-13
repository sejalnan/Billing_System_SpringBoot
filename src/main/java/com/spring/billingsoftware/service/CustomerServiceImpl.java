package com.spring.billingsoftware.service;

import com.spring.billingsoftware.Interface.CustomerService;
import com.spring.billingsoftware.entity.Customer;
import com.spring.billingsoftware.exception.ResourceNotFoundException;
import com.spring.billingsoftware.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
          return repository.addCustomer(customer);

    }

    @Override
    public Customer updateCustomerDetails(String id, Customer customer) {
        try
        {
            repository.updateById(id, customer);

        }
        catch (ResourceNotFoundException e)
        {
            throw e;
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
       return repository.findAllCustomers();
    }

    @Override
    public Customer getCustomerById(String id) {
        return  repository.findCutomerById(id);

    }
}
