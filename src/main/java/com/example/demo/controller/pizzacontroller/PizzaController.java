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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        this.pizzaApplication.delete(id);
        return ResponseEntity.status(204).body("");
    }

    @DeleteMapping(path = "/{id}/ingredients/{ingredientId}")
    public ResponseEntity<?> removeIngredient(@PathVariable UUID id, @PathVariable UUID ingredientId) {
        this.pizzaApplication.removeIngredient(id, ingredientId);
        return ResponseEntity.status(204).body("");
    }

    //método para agregar un nuevo ingrediente
}
// pizzas ---- > detalle de cada pizza: se meten comentarios

/*Para añadir comentarios:
1º la pizza tiene que estar creada
2º Tenemos que buscar la pizza para traerla
3º Escribir el comentario
4º El comentario se debe guardar con la pizza
5º para saber si hemos guardado el comentario, tenemos que pedir la pizza

*/