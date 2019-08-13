package com.robosh.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "orders")
public class Order {
    @Id
    @Column(name="order_id")
    @GeneratedValue
    private long id;
    @NonNull
    private String address;
    @GeneratedValue
    private Date date;
    @NonNull
    private float bill;
    private boolean paid = false;
    private boolean checked = false;

    @OneToOne
    @JoinColumn(name="user_user_id")
    private User user;
}
