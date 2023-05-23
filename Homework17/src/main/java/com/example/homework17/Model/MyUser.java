package com.example.homework17.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MyUser {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Column(columnDefinition = "varchar(4) not null")
    private String name;

    @NotEmpty(message = "Username is required")
    @Column(columnDefinition = "varchar(4) not null unique")
    private String username;

    @NotEmpty(message = "Password is required")
    @Column(columnDefinition = "varchar(8) not null")
    private String password;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid Email",regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @Column(columnDefinition = "varchar(30) not null unique check (email like '%_@__%.__%')")
    //CHECK (REGEXP_LIKE (email,'^\w+(\.\w+)*+@\w+(\.\w+)+$'))
    private String email;

    @NotEmpty(message = "Role is required")
    @Pattern(regexp = "\\b(?:admin|user)\\b",message = "Role Not Valid")
    @Column(columnDefinition = "varchar(20) not null check(role='user' or role='admin')")
    private String role;

    @NotNull(message = "Age is required")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
