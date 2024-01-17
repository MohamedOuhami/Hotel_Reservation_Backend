package com.v01d.hotel_reservation.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String firstName,lastName,adress;
    private LocalDate birthDate;

}
