package com.example.demo.infraestructure.ingredientinfraestructure;

import java.util.UUID;
import com.example.demo.domain.ingredientdomain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientJPARepository extends JpaRepository<Ingredient, UUID> {
}
