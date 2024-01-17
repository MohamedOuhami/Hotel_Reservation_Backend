package com.v01d.hotel_reservation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.v01d.hotel_reservation.entities.User;
import com.v01d.hotel_reservation.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/users")
public class ClientController {

    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }

    // Update user
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId,@RequestBody User newUser){
       return userService.updateUser(userId, newUser);
    }

    // findAllUsers
    @GetMapping
    public List<User> findAll() {
    return userService.findAll();
    }
    // findByID

    @GetMapping("/{userId}")
    public ResponseEntity<User> findById(int userId){
        return userService.findById(userId);
    }
}
