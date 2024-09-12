package com.example.tddminiproj.model;

import jakarta.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name must not be empty")
    private String customerName;

    private LocalDate orderDate;

    @NotBlank(message = "Shipping address must not be empty")
    private String shippingAddress;

    @Positive(message = "Total must be positive")
    private Double total;
}