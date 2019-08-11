package com.robosh.entities;

import com.robosh.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Role role;

}
