package com.v01d.hotel_reservation.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.v01d.hotel_reservation.entities.Reservation;
import com.v01d.hotel_reservation.entities.ReservationPK;
import com.v01d.hotel_reservation.services.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // CRUD endpoints
    @PostMapping
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable ReservationPK id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable ReservationPK id) {
        return reservationService.deleteReservationById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable ReservationPK id, @RequestBody Reservation updatedEntity) {
        return reservationService.updateReservation(id, updatedEntity);
    }
}
