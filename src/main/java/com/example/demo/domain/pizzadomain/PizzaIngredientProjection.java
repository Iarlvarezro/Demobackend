package com.example.demo.domain.pizzadomain;


import java.util.List;
import java.util.UUID;

public interface PizzaIngredientProjection {

    public UUID getId();

    public String getName();

    public Double getPrice();

    public String getDescription();

    public List<Ingredient> getIngredients();

    public List<Comment> getComments();

    public Image getImage();

    public interface Image {
        public String getPublic_id();
    };

    public interface Ingredient {

        public UUID getId();

        public String getName();
    }

    public interface Comment {

        public UUID getId();

        public String getText();

        public int getScore();

    }


}
