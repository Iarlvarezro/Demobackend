package com.example.demo.domain.pizzadomain;

import java.util.Optional;
import java.util.UUID;

public interface PizzaRepository {
    public void add(Pizza pizza);
    public Optional<Pizza> findById(UUID id);
    public void update(Pizza pizza);
    public void delete(Pizza pizza);
}
