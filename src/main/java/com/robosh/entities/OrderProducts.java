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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
    @ManyToMany
    @JoinTable(
            name = "dishes",
            joinColumns = {@JoinColumn(name = "order_products_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id")}
    )
    private List<Dish> dishList;
    @ManyToMany
    @JoinTable(
            name = "drinks",
            joinColumns = {@JoinColumn(name = "order_products_id")},
            inverseJoinColumns = {@JoinColumn(name = "drink_id")}
    )
    private List<Drink> drinkList;

    public void addDish(Dish dish) {
        dishList.add(dish);
    }

    public void addDrink(Drink drink) {
        drinkList.add(drink);
    }

    public void deleteDish(Dish dish) {
        dishList.remove(dish);
    }

    public void deleteDrink(Drink drink) {
        drinkList.remove(drink);
    }

}
