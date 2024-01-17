package com.v01d.hotel_reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v01d.hotel_reservation.entities.Reservation;
import com.v01d.hotel_reservation.entities.ReservationPK;
import com.v01d.hotel_reservation.repositories.ReservationRepo;

import org.springframework.http.ResponseEntity;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepository;

    // CRUD methods
    public ResponseEntity<Reservation> saveReservation(Reservation reservation) {
        Reservation savedEntity = reservationRepository.save(reservation);
        return ResponseEntity.ok(savedEntity);
    }

    public ResponseEntity<Reservation> getReservationById(ReservationPK id) {
        Reservation foundEntity = reservationRepository.findById(id).orElse(null);
        return foundEntity != null ? ResponseEntity.ok(foundEntity) : ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> entities = reservationRepository.findAll();
        return ResponseEntity.ok(entities);
    }

    public ResponseEntity<Void> deleteReservationById(ReservationPK id) {
        reservationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Reservation> updateReservation(ReservationPK id, Reservation updatedEntity) {
        if (!reservationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedEntity.setReservationPK(id);
        Reservation result = reservationRepository.save(updatedEntity);
        return ResponseEntity.ok(result);
    }
}   
