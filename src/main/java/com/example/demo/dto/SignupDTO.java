package com.example.demo.dto;

import com.example.demo.bean.Role;
import com.example.demo.bean.Services;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
public class SignupDTO {
    @NotBlank
    @Size(min = 3, max = 30)
    private String username;
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, max = 60)
    private String password;
    @NotBlank
    @Size(min = 6, max = 60)
    private String phone;
    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @NotNull
    @DBRef
    private Role role;
    @NotNull
    @DBRef
    private Services services;
}
