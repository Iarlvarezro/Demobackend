package com.example.demo.domain.pizzadomain;

import java.util.UUID;


import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.dto.pizzadtos.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzadtos.PizzaDTO;
import com.example.demo.dto.pizzadtos.PizzaIngredientDTO;

public class PizzaService {
    public static Pizza create(CreateOrUpdatePizzaDTO dto) {
        Pizza pizza = new Pizza();
        pizza.id = UUID.randomUUID();
        pizza.name = dto.name;
        return pizza;
    }

    public static PizzaDTO createDTO(Pizza pizza) {
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.id = pizza.id;
        pizzaDTO.name = pizza.name;
        pizzaDTO.price = pizza.getPrice();
        for (Ingredient ingredient : pizza.ingredients) {
            PizzaIngredientDTO pizzaIngredientDTO = new PizzaIngredientDTO();
            pizzaIngredientDTO.id = ingredient.id;
            pizzaIngredientDTO.name = ingredient.name;
            pizzaDTO.ingredients.add(pizzaIngredientDTO);
        }
        return pizzaDTO;
    }
}
