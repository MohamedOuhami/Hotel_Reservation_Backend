package com.v01d.hotel_reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.v01d.hotel_reservation.entities.Reservation;
import com.v01d.hotel_reservation.entities.ReservationPK;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,ReservationPK>{
    
}
