package com.v01d.hotel_reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.v01d.hotel_reservation.entities.User;
import com.v01d.hotel_reservation.repositories.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // Create users

    public ResponseEntity<User> createUser(User user){
        User newUser = userRepo.save(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    // Delete user
    public ResponseEntity<Void> deleteUser(int userId){
        Optional<User> userOpt = userRepo.findById(userId);
        if(userOpt.isPresent()){
            userRepo.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Update user

    public ResponseEntity<User> updateUser(int userId,User newUser){
        Optional<User> userOptional = userRepo.findById(userId);

        if(userOptional.isPresent()){
            User oldUser = userOptional.get();
            newUser.setId(oldUser.getId());
            userRepo.save(newUser);

            return new ResponseEntity<>(newUser,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // findAllUsers
    public List<User> findAll() {
        return userRepo.findAll();
    }
    // findByID

    public ResponseEntity<User> findById(int userId){
        Optional<User> userOptional = userRepo.findById(userId);

        if (userOptional.isPresent()){
            User user = userOptional.get();

            return new ResponseEntity<>(user,HttpStatus.OK); 
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
