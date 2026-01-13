package com.spring.billingsoftware.repository;

import com.spring.billingsoftware.entity.Product;
import com.spring.billingsoftware.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {
    private final ArrayList<Product> list=new ArrayList<>();

    public Product add(Product product){
        list.add(product);
        return product;
    }

    public List<Product> findAllProducts(){
        return list;
    }

    public Product findProductById(int id){
        return list.stream().filter
                (p->p.getId()== id).findFirst().orElse(null);

    }

    public void deleteProduct(int product){

    list.remove(product);
    }

    public Product updateProduct(int id,Product product){

        Product existingProduct=findProductById(id);
        if(existingProduct!=null){
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStockQuantity(product.getStockQuantity());
            return existingProduct;
        }else{
            throw new ResourceNotFoundException("Product Not Fouund");
        }
    }

}