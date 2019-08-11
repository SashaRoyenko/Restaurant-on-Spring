package com.robosh.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrderProducts {
    private long id;
    private User user;
    private List<Dish> dishList;
    private List<Drink> drinkList;

}
