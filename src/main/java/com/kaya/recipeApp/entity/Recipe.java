package com.kaya.recipeApp.entity;


import com.kaya.recipeApp.domain.recipe.RecipeRequest;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recipe")
public class Recipe extends BaseEntity {
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name="recipe_ingredients",
            joinColumns = @JoinColumn(name="recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_item_id")
    )
    private Set<Ingredient> ingredients;

    @Column(unique = true,updatable = false)
    private String title;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String instructions;


    @Column(name = "created_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime createdDate;

    @PrePersist
    public void init() {
        this.createdDate = ZonedDateTime.now()
                .truncatedTo(ChronoUnit.SECONDS);
    }

}
