package com.v01d.hotel_reservation.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.v01d.hotel_reservation.entities.Room;
import com.v01d.hotel_reservation.services.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // CRUD endpoints
    @PostMapping
    public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return roomService.getAllRooms();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomById(@PathVariable Integer id) {
        return roomService.deleteRoomById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Integer id, @RequestBody Room updatedEntity) {
        return roomService.updateRoom(id, updatedEntity);
    }
}