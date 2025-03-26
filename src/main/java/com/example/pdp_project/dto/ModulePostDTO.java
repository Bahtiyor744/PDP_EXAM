package com.example.pdp_project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModulePostDTO {
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Name cannot be null")
    private Integer courseId;
}