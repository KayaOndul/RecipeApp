package com.kaya.recipeApp.domain.items;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.recipeApp.enums.Unit;
import lombok.Data;

@Data
public class ItemModel {
    @JsonProperty("ingredient_id")
    private String id;
    private Integer amount;
    private Unit unit;
}
