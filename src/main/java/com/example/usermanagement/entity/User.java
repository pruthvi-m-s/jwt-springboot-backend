package com.example.usermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String username;   // username for login

    @NotBlank
    private String password;   // encrypted password

    @NotBlank
    private String role;       // e.g., ROLE_USER or ROLE_ADMIN

    private String name;       // user full name
    private Integer age;

    public User() {}

    public User(String username, String password, String role, String name, Integer age) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.age = age;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}