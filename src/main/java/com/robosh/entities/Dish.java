package com.robosh.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @Column(name = "dish_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private float price;
    @NonNull
    private short weight;
    @NonNull

    @ManyToMany
    @JoinTable(
            name = "dish_ingredients",
            joinColumns = {@JoinColumn(name = "dish_dish_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_ingredient_id")}
    )
    private List<Ingredient> ingredientList = new ArrayList<>();

}
