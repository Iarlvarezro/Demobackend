package com.example.demo.controller.pizzacontroller;

import java.util.UUID;

import com.example.demo.application.pizzaapplication.PizzaApplication;
import com.example.demo.dto.pizzadtos.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzadtos.PizzaDTO;
import com.example.demo.dto.commentdtos.CommentDTO;
import com.example.demo.dto.commentdtos.CreateCommentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/pizzas")
public class PizzaController {
    private final PizzaApplication pizzaApplication;

    @Autowired
    public PizzaController(final PizzaApplication pizzaApplication) {
        this.pizzaApplication = pizzaApplication;

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody final CreateOrUpdatePizzaDTO dto) {
        PizzaDTO pizzaDTO = this.pizzaApplication.add(dto);
        return ResponseEntity.status(201).body(pizzaDTO);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}/comments")
    public ResponseEntity<?> addComment(@PathVariable UUID id, @RequestBody CreateCommentDTO createCommentDTO) {
        CommentDTO commentDTO = this.pizzaApplication.addComment(id, createCommentDTO);
        return ResponseEntity.status(201).body(commentDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        PizzaDTO pizzadto = this.pizzaApplication.get(id);
        return ResponseEntity.ok(pizzadto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.pizzaApplication.delete(id);
        return ResponseEntity.status(204).body("");
    }

    @DeleteMapping(path = "/{id}/ingredients/")
    public ResponseEntity<?> removeIngredient(@PathVariable UUID id, UUID ingredientId) {
        this.pizzaApplication.removeIngredient(id, ingredientId);
        return ResponseEntity.status(204).body("");
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}/ingredients/{ingredientId}")
    public ResponseEntity<?> addIngredient(@PathVariable UUID id,@PathVariable UUID ingredientId) {
        PizzaDTO pizzadto = this.pizzaApplication.addIngredient(id, ingredientId);
        return ResponseEntity.status(204).body(pizzadto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(
        @RequestParam(required = false) String name,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.status(200).body(this.pizzaApplication.getAll(name, page, size));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}/ingredients")
    public ResponseEntity<?> getIngredientPrice(@PathVariable UUID id) {
        PizzaDTO pizzadto = this.pizzaApplication.getIngredientPrice(id);
        return ResponseEntity.ok(pizzadto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}/comments")
    public ResponseEntity<?> getPizzaComment(@PathVariable UUID id) {
        PizzaDTO pizzadto = this.pizzaApplication.getPizzaComment(id);
        return ResponseEntity.ok(pizzadto);
    }
}
