package com.example.backend.controller;

import com.example.backend.model.PriceCalculation;
import com.example.backend.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private PricingService pricingService;

    @GetMapping("/calculate")
    public PriceCalculation calculatePrice(
            @RequestParam String productName,
            @RequestParam int quantity
    ) {
        return pricingService.calculatePrice(productName, quantity);
    }

    @GetMapping("/price-list")
    public List<PriceCalculation> getPriceList(@RequestParam String productName) {
        return pricingService.generatePriceList(productName);
    }
}