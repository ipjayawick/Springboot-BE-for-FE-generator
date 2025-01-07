package com.example.springbootbe.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    // Custom query method to find pets by status
    List<Pet> findByStatus(Pet.Status status);

    // Custom query method to find pets by name (optional, if needed)
    List<Pet> findByName(String name);
}
