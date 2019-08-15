package com.robosh.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String address;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private float bill;
    private boolean paid = false;
    private boolean checked = false;

    @OneToOne
    @JoinColumn(name = "user_user_id")
    private User user;
}
