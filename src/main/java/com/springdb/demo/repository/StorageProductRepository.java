package com.springdb.demo.repository;

import com.springdb.demo.model.StorageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageProductRepository extends JpaRepository<StorageProduct, Long> {
}
