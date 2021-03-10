Ingredientes --> Filtro por nombre  |
                                    |-> mediante @query y projection        
Pizzas --> Filtro por nombre        |

@Query
Projection

Editar una pizza


1. Usuario que puede agregar o quitar ingredientes
    puede ver el precio del ingrediente
2. Usuario que quiere comentar pero no puede ni
agregar ni quitar pizzas
    no puede el precio del ingrediente


1. get [] /ingredientes query/projection
2. get [] /pizzas query/projection

3. get {} + ingredientes con su precio aplicacion --> for 
4. get {} +[] ingredientes sin precio + [] comments --> parte de detalles

3 y 4 se pueden hacer con un bucle for



--------------------------------------

## Projection:
{
    id,
    name,
    precio,
    imagen,
    ingredientes[]
    comments[]
}

se proyecta: {id, name, precio}

@Query es una notación de JPA, por lo que hay que referenciarlo en el JPArepository


## TO DO
get allingredients y get allingredients + comments
```Java
    public PizzaDTO getPizzaIngredients() { //para ingredients
        Pizza pizza = PizzaService.create(pizzadto);
        for (UUID ingredientId : pizzadto.ingredients) {
            Ingredient ingredient = this.ingredientRepository.findById(ingredientId).orElseThrow();
            pizza.addIngredient(ingredient);
        }
        Double price = pizza.calculatePrice();
        pizza.setPrice(price);
        return PizzaService.createDTO(pizza);
    }

    public PizzaDTO getPizzaDetails() {//para details
        Pizza pizza = PizzaService.create(pizzadto);
        for (UUID ingredientId : pizzadto.ingredients) {
            Ingredient ingredient = this.ingredientRepository.findById(ingredientId).orElseThrow();
            pizza.addIngredient(ingredient);
        }
        for (UUID commentId: pizzadto.comments) {
            Comment comment = this.pizzaRepository.findById(commentId).orElseThrow();

        }
        Double price = pizza.calculatePrice();
        pizza.setPrice(price);
        return PizzaService.createDTO(pizza);
    }
```




@param -> requiere tipo string por que?