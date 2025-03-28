package com.example.backend.service;

import com.example.backend.model.PriceCalculation;
import com.example.backend.model.Product;
import com.example.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PricingService {
    @Autowired
    private ProductRepository productRepository;

    public PriceCalculation calculatePrice(String productName, int quantity) {
        Product product = productRepository.findByName(productName)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        PriceCalculation calculation = new PriceCalculation();
        calculation.setProductName(productName);
        calculation.setQuantityRequested(quantity);

        // Calculate cartons and single units
        int cartons = quantity / product.getUnitsPerCarton();
        int singleUnits = quantity % product.getUnitsPerCarton();

        // Calculate carton price with potential discount
        double cartonPrice = product.getCartonPrice() * cartons;
        if (cartons >= 2) {
            cartonPrice *= 0.8; // 20% discount for 2 or more cartons
        }

        // Calculate single unit price
        double singleUnitPrice = product.getCartonPrice() / product.getUnitsPerCarton() * 1.2 * singleUnits;

        // Total price calculation
        double totalPrice = cartonPrice + singleUnitPrice;

        calculation.setCartons(cartons);
        calculation.setSingleUnits(singleUnits);
        calculation.setTotalPrice(totalPrice);

        return calculation;
    }

    public List<PriceCalculation> generatePriceList(String productName) {
        List<PriceCalculation> priceList = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            priceList.add(calculatePrice(productName, i));
        }
        return priceList;
    }
}