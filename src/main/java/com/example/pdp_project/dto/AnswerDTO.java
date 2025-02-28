package com.example.pdp_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor()
public class AnswerDTO {
    private Integer id;
    private String text;
    private Integer questionId;
}
