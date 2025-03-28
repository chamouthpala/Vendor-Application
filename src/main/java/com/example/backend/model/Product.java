package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double cartonPrice;
    private int unitsPerCarton;
    private double singleUnitPriceMultiplier;

    // Constructors
    public Product() {}

    public Product(String name, double cartonPrice, int unitsPerCarton) {
        this.name = name;
        this.cartonPrice = cartonPrice;
        this.unitsPerCarton = unitsPerCarton;
        this.singleUnitPriceMultiplier = 1.2; // 20% markup for single units
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getCartonPrice() { return cartonPrice; }
    public void setCartonPrice(double cartonPrice) { this.cartonPrice = cartonPrice; }
    public int getUnitsPerCarton() { return unitsPerCarton; }
    public void setUnitsPerCarton(int unitsPerCarton) { this.unitsPerCarton = unitsPerCarton; }
    public double getSingleUnitPriceMultiplier() { return singleUnitPriceMultiplier; }
    public void setSingleUnitPriceMultiplier(double singleUnitPriceMultiplier) {
        this.singleUnitPriceMultiplier = singleUnitPriceMultiplier;
    }
}