package com.spring.billingsoftware.controller;

import com.spring.billingsoftware.Interface.CustomerService;
import com.spring.billingsoftware.entity.Customer;
import com.spring.billingsoftware.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")

public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {


        return new ResponseEntity <> (service.addCustomer(customer), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        try{
            return ResponseEntity.ok(service.getAllCustomers());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id){
        try{
            return ResponseEntity.ok(service.getCustomerById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
