package com.robosh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue
    @Column(name= "ingredient_id")
    private long id;
    @Column(name = "ingredient_name", nullable = false)
    private String name;

}
