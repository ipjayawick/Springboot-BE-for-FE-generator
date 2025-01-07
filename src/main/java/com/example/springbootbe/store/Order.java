package com.example.springbootbe.store;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "orderData")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long petId;  // Foreign key to Pet entity (if needed, you can create a relation)

    private Integer quantity;

    private String shipDate;  // String for ship date (you might want to use a Date type depending on your needs)

    @Enumerated(EnumType.STRING)  // Enum for order status
    private Status status;

    private Boolean complete;

    public enum Status {
        PLACED, APPROVED, DELIVERED
    }
}
