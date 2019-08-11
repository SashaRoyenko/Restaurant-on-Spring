package com.robosh.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Dish {
    private long id;
    private String name;
    private float price;
    private short weight;
    private List<Ingredient> ingredientList = new ArrayList<>();

}
