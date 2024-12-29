package com.kmuniz.storeapi.domain;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table  (name = "users")
public class User {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private UserType userType;
    private LocalDateTime dateCreated;
}
