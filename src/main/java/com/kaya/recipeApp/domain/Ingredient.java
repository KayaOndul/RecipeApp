package com.kaya.recipeApp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.recipeApp.enums.VegetarianType;
import com.kaya.recipeApp.enums.Unit;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient{

    private String name;

    private Integer amount;

    private Unit unit;

}
