package com.example.springbootbe.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    // Create or update a pet
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    // Get all pets
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    // Get pet by ID
    public Pet getPetById(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        return pet.orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
    }

    // Get pets by status
    public List<Pet> getPetsByStatus(Pet.Status status) {
        return petRepository.findByStatus(status);
    }

    // Update a pet (you can implement a method for partial update if needed)
    public Pet updatePet(Long id, Pet updatedPet) {
        if (petRepository.existsById(id)) {
            updatedPet.setId(id);
            return petRepository.save(updatedPet);
        } else {
            throw new RuntimeException("Pet not found with id: " + id);
        }
    }

    // Delete a pet by ID
    public void deletePet(Long id) {
        if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pet not found with id: " + id);
        }
    }
}
