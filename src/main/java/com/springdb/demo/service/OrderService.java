package com.springdb.demo.service;

import com.springdb.demo.model.*;
import com.springdb.demo.repository.OrderRepository;
import com.springdb.demo.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createStorage(Order order){
        return orderRepository.save(order);
    }

    public Order addProductsToOrder(Long id, Map<Product,Integer> products){
        Order o = orderRepository.getById(id);
        o.getProducts().addAll(products
                .keySet()
                .stream()
                .map( pr -> {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setOrder(o);
                    orderProduct.setProduct(pr);
                    orderProduct.setAmount(products.get(pr));
                    return orderProduct;
                })
                .collect(Collectors.toList()));
        return orderRepository.save(o);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order getById(Long id) {
        return orderRepository.getById(id);
    }


}
