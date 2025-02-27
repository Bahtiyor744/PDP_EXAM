package com.example.pdp_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class QuestionDTO {
    private Integer id;
    private String text;
    private Integer moduleId;
}
