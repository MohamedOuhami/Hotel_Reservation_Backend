package com.v01d.hotel_reservation.controllers;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.v01d.hotel_reservation.entities.Image;
import com.v01d.hotel_reservation.services.ImageService;

@RestController
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // CRUD endpoints
    @PostMapping
    public ResponseEntity<Image> saveImage(@RequestBody Image image) {
        return imageService.saveImage(image);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Integer id) {
        return imageService.getImageById(id);
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        return imageService.getAllImages();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageById(@PathVariable Integer id) {
        return imageService.deleteImageById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Integer id, @RequestBody Image updatedEntity) {
        return imageService.updateImage(id, updatedEntity);
    }
}       