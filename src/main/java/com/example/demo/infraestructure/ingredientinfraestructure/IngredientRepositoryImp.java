package com.example.demo.infraestructure.ingredientinfraestructure;

import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepositoryImp implements IngredientRepository {

    private final IngredientJPARepository ingredientJPARepository;
    
    @Autowired 
    //constructor 
    public IngredientRepositoryImp(final IngredientJPARepository ingredientJPARepository){
        this.ingredientJPARepository = ingredientJPARepository;
    }
    @Override
    public void add(Ingredient ingredient){
        this.ingredientJPARepository.save(ingredient);
    }
    @Override
    public Optional<Ingredient> findById(UUID id) {
       return this.ingredientJPARepository.findById(id);
    }
    @Override
    public void update(Ingredient ingredient) {
        this.ingredientJPARepository.save(ingredient);
    }
    @Override
    public void delete(Ingredient ingredient) {
        this.ingredientJPARepository.delete(ingredient);
    }
}
