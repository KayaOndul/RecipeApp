package com.kaya.recipeApp.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.recipeApp.domain.Ingredient;
import com.kaya.recipeApp.enums.VegetarianType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "recipe")
public class Recipe {
    @Id
    private String id;

    @Indexed(unique = true)
    private String title;

    @Field(name = "ingredients")
    private Set<Ingredient> ingredients=new HashSet<>();

    private String instructions;

    private Integer forPerson;

    @JsonProperty("vegetarian")
    private VegetarianType vegetarianType;

    @CreatedDate
    private LocalDateTime createdDate;
}
