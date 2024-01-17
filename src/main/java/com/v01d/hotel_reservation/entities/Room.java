package com.v01d.hotel_reservation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Room implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name,type;

    @OneToMany
    private List<Image> images;
}
