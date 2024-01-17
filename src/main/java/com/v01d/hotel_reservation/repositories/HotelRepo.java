package com.v01d.hotel_reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.v01d.hotel_reservation.entities.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer>{
    
}
