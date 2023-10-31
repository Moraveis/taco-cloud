package com.spring.action.tacocloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    private String id;
    private String name;
    private IngredientType type;

}
