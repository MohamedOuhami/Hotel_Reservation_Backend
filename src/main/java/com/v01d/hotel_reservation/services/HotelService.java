package com.v01d.hotel_reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v01d.hotel_reservation.entities.Hotel;
import com.v01d.hotel_reservation.repositories.HotelRepo;

import org.springframework.http.ResponseEntity;

@Service
public class HotelService {

    @Autowired
    private HotelRepo HotelRepository;

    // CRUD methods
    public ResponseEntity<Hotel> saveHotel(Hotel Hotel) {
        Hotel savedEntity = HotelRepository.save(Hotel);
        return ResponseEntity.ok(savedEntity);
    }

    public ResponseEntity<Hotel> getHotelById(Integer id) {
        Hotel foundEntity = HotelRepository.findById(id).orElse(null);
        return foundEntity != null ? ResponseEntity.ok(foundEntity) : ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> entities = HotelRepository.findAll();
        return ResponseEntity.ok(entities);
    }

    public ResponseEntity<Void> deleteHotelById(Integer id) {
        HotelRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Hotel> updateHotel(Integer id, Hotel updatedEntity) {
        if (!HotelRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedEntity.setId(id);
        Hotel result = HotelRepository.save(updatedEntity);
        return ResponseEntity.ok(result);
    }
}