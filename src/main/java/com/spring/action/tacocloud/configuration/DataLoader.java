package com.spring.action.tacocloud.configuration;

import com.spring.action.tacocloud.domain.Ingredient;
import com.spring.action.tacocloud.domain.IngredientType;
import com.spring.action.tacocloud.domain.Taco;
import com.spring.action.tacocloud.repository.IngredientRepository;
import com.spring.action.tacocloud.repository.TacoRepository;
import com.spring.action.tacocloud.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner dataLoaderCommand(IngredientRepository ingredientRepository, UserRepository userRepository, PasswordEncoder encoder, TacoRepository tacoRepository) {
        return args -> {
            Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP);
            Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP);
            Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN);
            Ingredient carnitas = new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN);
            Ingredient dicedTomatoes = new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES);
            Ingredient lettuce = new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES);
            Ingredient cheddar = new Ingredient("CHED", "Cheddar", IngredientType.CHEESE);
            Ingredient monterreyJack = new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE);
            Ingredient salsa = new Ingredient("SLSA", "Salsa", IngredientType.SAUCE);
            Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE);

            ingredientRepository.saveAll(List.of(flourTortilla, cornTortilla, groundBeef, carnitas, dicedTomatoes, lettuce, cheddar, monterreyJack, salsa, sourCream));

            Taco carnivore = new Taco();
            carnivore.setName("Carnivore");
            carnivore.setIngredients(List.of(flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar));
            tacoRepository.save(carnivore);

            Taco bovineBounty = new Taco();
            bovineBounty.setName("Bovine Bounty");
            bovineBounty.setIngredients(List.of(cornTortilla, groundBeef, cheddar, monterreyJack, sourCream));
            tacoRepository.save(bovineBounty);

            Taco vegout = new Taco();
            vegout.setName("Veg-Out");
            vegout.setIngredients(List.of(flourTortilla, cornTortilla, dicedTomatoes, lettuce, salsa));
            tacoRepository.save(vegout);
        };
    }


}
