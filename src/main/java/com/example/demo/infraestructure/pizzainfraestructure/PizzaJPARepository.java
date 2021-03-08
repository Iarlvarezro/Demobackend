package com.example.demo.infraestructure.pizzainfraestructure;

import java.util.UUID;

import com.example.demo.domain.pizzadomain.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaJPARepository extends JpaRepository<Pizza, UUID> {

}
