package com.spring.billingsoftware.Interface;

import com.spring.billingsoftware.entity.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);
    public Product updateProduct(int id,Product product);
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public void deleteProduct(int product);

}
