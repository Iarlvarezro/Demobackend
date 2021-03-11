package com.example.demo.domain.pizzadomain;

import java.util.UUID;

import com.example.demo.domain.commentdomain.Comment;
import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.dto.pizzadtos.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzadtos.PizzaCommentDTO;
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

    public static PizzaDTO createDTOPrice(Pizza pizza) {
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.id = pizza.id;
        pizzaDTO.name = pizza.name;
        pizzaDTO.price = pizza.getPrice();
        for (Ingredient ingredient : pizza.ingredients) {
            PizzaIngredientDTO pizzaIngredientDTO = new PizzaIngredientDTO();
            pizzaIngredientDTO.id = ingredient.id;
            pizzaIngredientDTO.name = ingredient.name;
            pizzaIngredientDTO.price = ingredient.price;
            pizzaDTO.ingredients.add(pizzaIngredientDTO);
        }
        return pizzaDTO;
    }

    public static PizzaDTO createDTOComment(Pizza pizza) {
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
        for (Comment comment : pizza.comments) {
            PizzaCommentDTO pizzaCommentDTO = new PizzaCommentDTO();
            pizzaCommentDTO.id = comment.id;
            pizzaCommentDTO.text = comment.text;
            pizzaCommentDTO.date= comment.date;
            pizzaCommentDTO.score = comment.score;
            pizzaDTO.comments.add(pizzaCommentDTO);
        }
        return pizzaDTO;
    }

}
