package com.example.pdp_project.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
    @Email(message = "Incorrect email")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String email;
}
