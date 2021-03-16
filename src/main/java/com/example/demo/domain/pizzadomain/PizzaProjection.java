package com.example.demo.domain.pizzadomain;


import java.util.UUID;

public interface PizzaProjection {
    
    UUID getId();

    String getName();

    public Double getPrice();

    public Image getImage();

    public interface Image {
        public String getPublic_Id();
    };

    
}
