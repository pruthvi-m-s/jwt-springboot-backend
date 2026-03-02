package com.example.usermanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Role is required")
    private String role; // e.g., ROLE_USER

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 1, message = "Age must be at least 1")
    private Integer age;

    public UserRequestDTO() {}

    public UserRequestDTO(String username, String password, String role, String name, Integer age) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.age = age;
    }

    // Getters & Setters
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