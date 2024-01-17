package com.v01d.hotel_reservation.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.v01d.hotel_reservation.entities.Hotel;
import com.v01d.hotel_reservation.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // CRUD endpoints
    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Integer id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable Integer id) {
        return hotelService.deleteHotelById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Integer id, @RequestBody Hotel updatedEntity) {
        return hotelService.updateHotel(id, updatedEntity);
    }
}