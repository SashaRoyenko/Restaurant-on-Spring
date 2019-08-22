package com.robosh.entities;

import com.robosh.entities.enums.Role;
import lombok.*;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
@Data

public class User implements Cloneable{
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "password", nullable = false)
    private String password;
    @Transient
    private String confirmPassword;
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //    @OneToOne(mappedBy = "user")
//    Order order;
//    @OneToOne(mappedBy = "user")
//    OrderProducts orderProducts;

}
