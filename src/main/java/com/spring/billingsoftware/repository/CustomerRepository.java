package com.spring.billingsoftware.repository;

import com.spring.billingsoftware.entity.Customer;
import com.spring.billingsoftware.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository {
    private final ArrayList<Customer> list = new ArrayList<Customer>();

    public List<Customer> findAllCustomers(){
        return list;
    }

    public Customer findCutomerById(String id){
        return list.stream().filter
                (c->c.getId()== id).findFirst().orElse(null);

    }
    public Customer addCustomer(Customer customer){
        list.add(customer);
        return customer;
    }
    public boolean updateById(String id,Customer customer){
        Customer existingCustomer=findCutomerById(id);
        if(existingCustomer!=null){
            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setPhone(customer.getPhone());

            return true;
        }else{
            throw new ResourceNotFoundException("Customer Not Found...");
        }
    }
}
