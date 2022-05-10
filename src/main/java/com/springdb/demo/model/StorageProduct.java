package com.springdb.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "storage_product")
public class StorageProduct {
    @EmbeddedId
    private StorageProductKey StorageProductId = new StorageProductKey();
    @ManyToOne
    @MapsId("productName")
    @JoinColumn(name = "product_name")
    private Product product;
    @ManyToOne
    @MapsId("storageId")
    @JoinColumn(name = "storage_id")
    @JsonIgnore
    private Storage storage;

    private int amount;
}
