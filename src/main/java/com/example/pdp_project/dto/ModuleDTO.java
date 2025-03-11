package com.example.pdp_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor()
public class ModuleDTO {
    private Integer id;
    private String title;
    private Integer courseId;
}

