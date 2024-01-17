package com.v01d.hotel_reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v01d.hotel_reservation.entities.Room;
import com.v01d.hotel_reservation.repositories.RoomRepo;

import org.springframework.http.ResponseEntity;

@Service
public class RoomService {

    @Autowired
    private RoomRepo roomRepository;

    // CRUD methods
    public ResponseEntity<Room> saveRoom(Room room) {
        Room savedEntity = roomRepository.save(room);
        return ResponseEntity.ok(savedEntity);
    }

    public ResponseEntity<Room> getRoomById(Integer id) {
        Room foundEntity = roomRepository.findById(id).orElse(null);
        return foundEntity != null ? ResponseEntity.ok(foundEntity) : ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> entities = roomRepository.findAll();
        return ResponseEntity.ok(entities);
    }

    public ResponseEntity<Void> deleteRoomById(Integer id) {
        roomRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Room> updateRoom(Integer id, Room updatedEntity) {
        if (!roomRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedEntity.setId(id);
        Room result = roomRepository.save(updatedEntity);
        return ResponseEntity.ok(result);
    }
}
