package com.springdb.demo.service;

import com.springdb.demo.model.StorageProduct;
import com.springdb.demo.repository.StorageProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageProductService {

    @Autowired
    private StorageProductRepository storageProductRepository;

    public List<StorageProduct> findAll() {
        return storageProductRepository.findAll();
    }
}
