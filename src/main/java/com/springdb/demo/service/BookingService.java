package com.springdb.demo.service;

import com.springdb.demo.model.Booking;
import com.springdb.demo.model.Storage;
import com.springdb.demo.model.StorageProduct;
import com.springdb.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService{

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private StorageService storageService;
    @Autowired
    private ProductService productService;

    public boolean createBooking(Booking booking) {
        List<Storage> temp = storageService.findAll()
                .stream()
                .filter(storage -> storage
                        .getProducts()
                        .stream()
                        .map(StorageProduct::getProduct)
                        .collect(Collectors.toList())
                        .contains(productService.getById(booking.getProduct().getProductName())))
                .collect(Collectors.toList());
        if(!temp.contains(storageService.getById(booking.getStorage().getId()))){
            return false;
        }
        bookingRepository.save(booking);
        return true;
    }

    public Booking getById(Long id) {
        return bookingRepository.getById(id);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}
