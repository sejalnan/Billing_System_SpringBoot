package com.spring.billingsoftware.controller;

import com.spring.billingsoftware.Interface.ProductService;
import com.spring.billingsoftware.entity.Product;
import com.spring.billingsoftware.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Products")

public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity <Product> (service.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            return ResponseEntity.ok(service.getAllProducts());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        try{
            return ResponseEntity.ok(service.getProductById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        try
        {
            service.deleteProduct(id);
            return "deleted Successfully";
        }catch (ResourceNotFoundException e) {
            return "Product not found";

        }

    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateById(@PathVariable int id,@RequestBody Product p){
        try{

            return ResponseEntity.ok(service.updateProduct(id,p));
        } catch (ResourceNotFoundException e) {

            return ResponseEntity.notFound().build();
        }

    }

}
