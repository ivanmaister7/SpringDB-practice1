package com.springdb.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_product")
public class OrderProduct {
    @EmbeddedId
    private OrderProductKey orderProductKey = new OrderProductKey();
    @ManyToOne
    @MapsId("productName")
    @JoinColumn(name = "product_name")
    private Product product;
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    private int amount;
}
