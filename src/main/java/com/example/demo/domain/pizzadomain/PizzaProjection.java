package com.example.demo.domain.pizzadomain;

import java.util.UUID;

public interface PizzaProjection {
    
    UUID getId();

    String getName();

    public Double getPrice();
}
