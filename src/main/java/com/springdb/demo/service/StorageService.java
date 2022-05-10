package com.springdb.demo.service;

import com.springdb.demo.model.Product;
import com.springdb.demo.model.Storage;
import com.springdb.demo.model.StorageProduct;
import com.springdb.demo.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    public Storage createStorage(Storage storage){
        return storageRepository.save(storage);
    }

    public Storage getById(Long id){
        return storageRepository.getById(id);
    }

    public Storage addProductsToStorage(Long id, Map<Product,Integer> products){
        Storage s = storageRepository.getById(id);
        s.getProducts().addAll(products
                .keySet()
                .stream()
                .map( pr -> {
                    StorageProduct storageProduct = new StorageProduct();
                    storageProduct.setStorage(s);
                    storageProduct.setProduct(pr);
                    storageProduct.setAmount(products.get(pr));
                    return storageProduct;
                })
                .collect(Collectors.toList()));
        return storageRepository.save(s);
    }

    public List<Storage> findAll() {
        return storageRepository.findAll();
    }
}
