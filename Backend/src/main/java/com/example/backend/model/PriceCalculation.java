package com.example.backend.model;

public class PriceCalculation {
    private String productName;
    private int quantityRequested;
    private int cartons;
    private int singleUnits;
    private double totalPrice;


    public PriceCalculation() {}


    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getQuantityRequested() { return quantityRequested; }
    public void setQuantityRequested(int quantityRequested) { this.quantityRequested = quantityRequested; }
    public int getCartons() { return cartons; }
    public void setCartons(int cartons) { this.cartons = cartons; }
    public int getSingleUnits() { return singleUnits; }
    public void setSingleUnits(int singleUnits) { this.singleUnits = singleUnits; }
    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}