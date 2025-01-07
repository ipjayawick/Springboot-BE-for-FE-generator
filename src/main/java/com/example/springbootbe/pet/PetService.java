package com.example.springbootbe.pet;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.springbootbe.pet.Pet;
import com.example.springbootbe.pet.PetRepository;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    public List<Pet> getPetsByStatus(Pet.Status status) {
        return petRepository.findByStatus(status);
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
