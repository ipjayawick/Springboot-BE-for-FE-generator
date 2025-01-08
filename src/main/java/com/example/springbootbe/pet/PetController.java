package com.example.springbootbe.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    // Get all pets
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    // Get a pet by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Pet pet = petService.getPetById(id);
        return ResponseEntity.ok(pet);
    }

    // Create a new pet
    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet createdPet = petService.savePet(pet);
        return ResponseEntity.ok(createdPet);
    }

    // Update an existing pet by Id
    @PostMapping("/{id}")
    public ResponseEntity<Pet> updatePetById(@PathVariable Long id,@RequestParam String name, @RequestParam Pet.Status status) {
        Pet updatedPet = petService.updatePet(id,name,status);
        return ResponseEntity.ok(updatedPet);
    }

    // Delete a pet by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
