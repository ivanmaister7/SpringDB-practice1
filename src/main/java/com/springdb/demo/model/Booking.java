package com.springdb.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "booking_")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long amount;

    @Column(nullable = false)
    private LocalDateTime bookingDate;

    @Column(nullable = false)
    private LocalDateTime untilDate;

    @ManyToOne
    @JoinColumn(name = "product_name", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;
}
