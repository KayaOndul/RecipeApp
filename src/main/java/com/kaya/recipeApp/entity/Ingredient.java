package com.kaya.recipeApp.entity;

import com.kaya.recipeApp.enums.IngredientType;
import com.kaya.recipeApp.enums.Unit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ingredient")
public class Ingredient extends BaseEntity {

    @ManyToMany(mappedBy = "ingredients")
    private Set<Recipe> recipes;

    private String name;

    @Enumerated(EnumType.STRING)
    private IngredientType ingredientType;


    private Integer amount;

    @Enumerated(EnumType.STRING)
    private Unit unit;


    @Column(name = "created_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime createdDate;

    @PrePersist
    public void init() {
        this.createdDate = ZonedDateTime.now()
                .truncatedTo(ChronoUnit.SECONDS);
    }

}
