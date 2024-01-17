package com.v01d.hotel_reservation.entities;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Reservation {
    
    @EmbeddedId
    private ReservationPK reservationPK;

    private LocalDate resDate;

    public Reservation(ReservationPK reservationPK,LocalDate resDate){
        this.reservationPK = reservationPK;
        this.resDate = resDate;
    }

}
