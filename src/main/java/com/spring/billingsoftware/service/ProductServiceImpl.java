package com.spring.billingsoftware.service;

import com.spring.billingsoftware.Interface.ProductService;
import com.spring.billingsoftware.entity.Product;
import com.spring.billingsoftware.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product addProduct(Product product) {
      return   repository.add(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        repository.updateProduct(id,product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAllProducts();
    }

    @Override
    public Product getProductById(int id) {
        return repository.findProductById(id);
    }

    @Override
    public void deleteProduct(int id) {
        repository.deleteProduct(id);
    }


}
