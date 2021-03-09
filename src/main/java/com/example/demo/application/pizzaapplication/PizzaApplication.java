package com.example.demo.application.pizzaapplication;

import java.util.UUID;

import com.example.demo.dto.commentdtos.CreateCommentDTO;
import com.example.demo.dto.pizzadtos.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzadtos.PizzaDTO;

public interface PizzaApplication {
    public PizzaDTO add(CreateOrUpdatePizzaDTO dto);

    public PizzaDTO get(UUID id);

    public void update(UUID id, CreateOrUpdatePizzaDTO dto);

    public void delete(UUID id);

    public void addComment(UUID id, UUID CommentId, CreateCommentDTO dto);
    // public void addIngredient(UUID id, UUID ingredientId);
    // public void removeIngredient(UUID id, UUID ingredientId);
}
