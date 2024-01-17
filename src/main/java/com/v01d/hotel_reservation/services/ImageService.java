package com.v01d.hotel_reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v01d.hotel_reservation.entities.Image;
import com.v01d.hotel_reservation.repositories.ImageRepo;

import org.springframework.http.ResponseEntity;

@Service
public class ImageService {

    @Autowired
    private ImageRepo imageRepository;

    // CRUD methods
    public ResponseEntity<Image> saveImage(Image image) {
        Image savedEntity = imageRepository.save(image);
        return ResponseEntity.ok(savedEntity);
    }

    public ResponseEntity<Image> getImageById(Integer id) {
        Image foundEntity = imageRepository.findById(id).orElse(null);
        return foundEntity != null ? ResponseEntity.ok(foundEntity) : ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> entities = imageRepository.findAll();
        return ResponseEntity.ok(entities);
    }

    public ResponseEntity<Void> deleteImageById(Integer id) {
        imageRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Image> updateImage(Integer id, Image updatedEntity) {
        if (!imageRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedEntity.setId(id);
        Image result = imageRepository.save(updatedEntity);
        return ResponseEntity.ok(result);
    }
}
