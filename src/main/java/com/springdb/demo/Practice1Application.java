package com.springdb.demo;

import com.springdb.demo.model.*;
import com.springdb.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class Practice1Application {
    @Autowired
    GroupService groupService;
    @Autowired
    ProductService productService;
    @Autowired
    StorageService storageService;
    @Autowired
    OrderService orderService;
    @Autowired
    BookingService bookingService;

    @GetMapping
    String test(){

        Group prodovolchi = new Group();
        prodovolchi.setGroupName("Prodovolchi");
        prodovolchi.setGroupInfo("...");
        groupService.createGroup(prodovolchi);

        Group neprodovolchi = new Group();
        neprodovolchi.setGroupName("Ne Prodovolchi");
        neprodovolchi.setGroupInfo("...");
        groupService.createGroup(neprodovolchi);

        Product grechka = new Product();
        grechka.setProductName("Grechka");
        grechka.setInfo("...");
        grechka.setManufacturer("Ukr");
        grechka.setPrice(20);
        grechka.setGroup(prodovolchi);
        productService.createProduct(grechka);

        Product muka = new Product();
        muka.setProductName("Muka");
        muka.setInfo("...");
        muka.setManufacturer("Ukr");
        muka.setPrice(30);
        muka.setGroup(prodovolchi);
        productService.createProduct(muka);

        Product book = new Product();
        book.setProductName("Book");
        book.setInfo("...");
        book.setManufacturer("USA");
        book.setPrice(50);
        book.setGroup(neprodovolchi);
        productService.createProduct(book);

        Product pen = new Product();
        pen.setProductName("Pen");
        pen.setInfo("...");
        pen.setManufacturer("Ger");
        pen.setPrice(10);
        pen.setGroup(neprodovolchi);
        productService.createProduct(pen);

        Storage storage1 = new Storage();
        storage1.setCity("Kiev");
        storage1.setAddress("Peremohy street");
        storageService.createStorage(storage1);
        Map<Product,Integer> prods = new HashMap<>();
        prods.put(grechka, 100);
        prods.put(muka, 200);
        prods.put(pen,1000);
        storageService.addProductsToStorage(1L, prods);

        Storage storage2 = new Storage();
        storage2.setCity("Lviv");
        storage2.setAddress("Central street");
        storageService.createStorage(storage2);
        prods.clear();
        prods.put(grechka, 1000);
        prods.put(book, 15500);
        prods.put(pen,2000);
        storageService.addProductsToStorage(2L, prods);

        Order order1 = new Order();
        order1.setCustomer("Ivan M.");
        order1.setStatus(OrderStatus.NEW);
        orderService.createStorage(order1);
        prods.clear();
        prods.put(grechka, 10);
        prods.put(book, 1);
        prods.put(muka,5);
        orderService.addProductsToOrder(1L, prods);

        Booking booking = new Booking();
        booking.setProduct(book);
        booking.setAmount(100);
        booking.setStorage(storage1);
        booking.setBookingDate(LocalDateTime.of(2022, 4, 8, 13, 0));
        booking.setUntilDate(LocalDateTime.of(2022, 4, 10, 12, 0));
        boolean res = bookingService.createBooking(booking);

        Booking booking1 = new Booking();
        booking1.setProduct(book);
        booking1.setAmount(100);
        booking1.setStorage(storage2);
        booking1.setBookingDate(LocalDateTime.of(2022, 4, 8, 13, 0));
        booking1.setUntilDate(LocalDateTime.of(2022, 4, 10, 12, 0));
        boolean res2 = bookingService.createBooking(booking1);

        return res + "\n" + res2;

    // return "ok";
    }

    @GetMapping("/product/{id}")
    Product product(@PathVariable String id){
        return productService.getById(id);
    }
    @GetMapping("/products")
    List<Product> products(){
        return productService.findAll();
    }


    @GetMapping("/group")
    boolean group(){
        return groupService.delete("Ne Prodovolchi");
    }
    @GetMapping("/groups")
    List<Group> groups(){
        return groupService.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(Practice1Application.class, args);
    }

}
