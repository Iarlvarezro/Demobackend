package com.example.demo.dto.pizzadtos;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class PizzaDTO {
    public UUID id;
    public String name;
    public Double price;
    public String description;
    public Set<PizzaIngredientDTO> ingredients = new HashSet<PizzaIngredientDTO>();
}
