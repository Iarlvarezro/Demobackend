package com.example.demo.application.pizzaapplication;

import java.util.UUID;

import com.example.demo.domain.commentdomain.Comment;
import com.example.demo.domain.commentdomain.CommentRepository;
import com.example.demo.domain.commentdomain.CommentService;
import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientRepository;
import com.example.demo.domain.pizzadomain.Pizza;
import com.example.demo.domain.pizzadomain.PizzaRepository;
import com.example.demo.domain.pizzadomain.PizzaService;
import com.example.demo.dto.commentdtos.CreateCommentDTO;
import com.example.demo.dto.pizzadtos.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzadtos.PizzaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaApplicationImp implements PizzaApplication {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PizzaApplicationImp(final PizzaRepository pizzaRepository, final IngredientRepository ingredientRepository, final CommentRepository commentRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public PizzaDTO add(CreateOrUpdatePizzaDTO pizzadto) {
        Pizza pizza = PizzaService.create(pizzadto);
        for (UUID ingredientId : pizzadto.ingredients) {
            Ingredient ingredient = this.ingredientRepository.findById(ingredientId).orElseThrow();
            pizza.addIngredient(ingredient);
        }
        Double price = pizza.calculatePrice();
        pizza.setPrice(price);
        this.pizzaRepository.add(pizza);
        return PizzaService.createDTO(pizza);
    }

    @Override
    public PizzaDTO get(UUID id) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        return PizzaService.createDTO(pizza);
    }

    @Override
    public void update(UUID id, CreateOrUpdatePizzaDTO dto) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        pizza.name = dto.name;
        this.pizzaRepository.update(pizza);
    }

    @Override
    public void delete(UUID id) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        this.pizzaRepository.delete(pizza);
    }

    public void addComment(UUID id, UUID CommentId, CreateCommentDTO commentdto) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        Comment comment = CommentService.create(commentdto);
        this.commentRepository.add(comment);
        pizza.addComment(comment);

    }
}
