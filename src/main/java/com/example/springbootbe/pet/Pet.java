package com.example.springbootbe.pet;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection // For storing arrays or collections
    @CollectionTable(name = "pet_photos", joinColumns = @JoinColumn(name = "pet_id"))
    @Column(name = "photo_url")
    private List<String> photoUrls;

    @Enumerated(EnumType.STRING) // Stores the enum as a string in the database
    private Status status;

    public enum Status {
        AVAILABLE, PENDING, SOLD
    }
}
