package com.v01d.hotel_reservation.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationPK implements Serializable{
    
    @ManyToOne
    private Room room; 

    @ManyToOne
    private User client;

}
