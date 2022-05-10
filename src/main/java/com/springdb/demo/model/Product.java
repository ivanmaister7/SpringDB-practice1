package com.springdb.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product_")
public class Product {
    @Id
    @Column(nullable = false, unique = true)
    private String productName;

    private String info;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private int price;

    @Formula("(select sum(sp.amount) from storage_product sp where sp.product_name = product_name)")
    private Long amount;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    //@OnDelete()
    private Collection<Booking> bookings = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "group_name", nullable = false)
    private Group group;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<StorageProduct> storages = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<OrderProduct> orders = new ArrayList<>();


}
