package com.springdb.demo.service;

import com.springdb.demo.model.Product;
import com.springdb.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public boolean delete(String id) {
        if(!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    public Product getById(String name) {
        return productRepository.getProductByProductName(name);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
