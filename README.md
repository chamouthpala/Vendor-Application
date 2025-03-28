# Vendor-Application
Designed to calculate pricing for products and display price List


## Stucture
Implemented using Spring boot 3.

## Database
Create database

    CREATE database assignment2;
Create Table
    
    CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    carton_price DECIMAL(10,2) NOT NULL,
    units_per_carton INT NOT NULL
    );

### Controller

#### ProductController

Handles HTTP requests

    GET /api/pricing/calculate?productName=X&quantity=Y

        Calculate the price for a given product and quantity

    GET /api/pricing/price-list?productName=X

        Generate price list table for seleted product 1-25

### Model

#### PriceCalculation

A simple POJO (Plain Old Java Object) to store results

#### Product

Represents a product in the database.

### Repository

#### ProductRepository

A Spring Data JPA repository for interacting with the database

    findByName method use to the find products using name.

### Service

#### PricingService
Implements pricing calculations.

    calculatePrice(String productName, int quantity)

        retrieves the product from database and calculate the price and do the logic

    generatePriceList(String productName)

        Generates a pricing list for 1 to 25 units using calculatePrice()




