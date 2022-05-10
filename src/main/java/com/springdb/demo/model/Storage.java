package com.springdb.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "storage_")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "storage", cascade = CascadeType.ALL)
    private Collection<StorageProduct> products = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "storage", cascade = CascadeType.ALL)
    private List<Booking> bookings;
}
