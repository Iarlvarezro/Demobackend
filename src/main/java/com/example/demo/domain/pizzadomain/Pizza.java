package com.example.demo.domain.pizzadomain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.example.demo.domain.commentdomain.Comment;
import com.example.demo.domain.ingredientdomain.Ingredient;

import org.hibernate.annotations.Type;

@Entity
public class Pizza {
    @Id
    @Type(type = "uuid-char")
    public UUID id;

    @Column(nullable = false)
    public String name;
    // Pasar price a privado y eliminar la columna
    private Double price;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }
    
    public void setPrice(Double value) {
        this.price = value;
    }

    // agregar la columna al getter y poner el nombre
    @Column(nullable = false, name = "price")
    public Double getPrice() {
        return price;
    }

    public Double calculatePrice() {
        Double total = 0.0;
        for (Ingredient ingredient : this.ingredients) {
            total += ingredient.price;
        }
        total = total * 1.2;
        return total;
    }

    @ManyToMany
    Set<Ingredient> ingredients = new HashSet<Ingredient>();

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "pizza_id")
    Set<Comment> comments = new HashSet<Comment>();
}
