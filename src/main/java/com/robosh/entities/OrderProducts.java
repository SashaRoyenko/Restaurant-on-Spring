package com.robosh.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "order_products")
public class OrderProducts {
    @Id
    @Column(name = "order_products_id")
    @GeneratedValue
    private long id;
    @OneToOne
    @JoinColumn (name="user_user_id")
    private User user;
    @ManyToMany
    @JoinTable(
            name="dishes",
            joinColumns ={@JoinColumn(name="order_products_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id")}
    )
    private List<Dish> dishList;
    @ManyToMany
    @JoinTable(
            name="drinks",
            joinColumns ={@JoinColumn(name="order_products_id")},
            inverseJoinColumns = {@JoinColumn(name = "drink_id")}
    )
    private List<Drink> drinkList;

}
