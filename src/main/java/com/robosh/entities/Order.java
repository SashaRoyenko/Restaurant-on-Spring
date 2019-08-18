package com.robosh.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "orders")
@Data
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
//    @Column(name = "is_paid", columnDefinition="TINYINT(1)")
    private boolean paid = false;
//    @Column(name = "is_checked", columnDefinition="TINYINT(1)")
    private boolean checked = false;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_user_id", referencedColumnName = "user_id", nullable = false)
    private User user;


}
