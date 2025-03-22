package com.example.pdp_project.dto;

import com.example.pdp_project.entity.Attachment;
import com.example.pdp_project.entity.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @NotBlank(message = "First Name is required")
    private String firstName;
    @NotBlank(message = "Last Name is required")
    private String lastName;
    @Email(message = "Incorrect email")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    private Attachment attachment;
}
