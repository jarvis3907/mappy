package de.smava.homework.auth.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {
    private String id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String roles;
}
