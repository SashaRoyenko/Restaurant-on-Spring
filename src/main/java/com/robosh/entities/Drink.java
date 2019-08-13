package com.robosh.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "drink")
public class Drink {
    @Id
    @Column(name = "drink_id")
    @GeneratedValue
    private long id;
    @Column(name = "drink_name", nullable = false)
    private String name;
    @Column(name = "drink_price", nullable = false)
    private float price;
    @Column(name = "drink_volume", nullable = false)
    private float volume;

}
