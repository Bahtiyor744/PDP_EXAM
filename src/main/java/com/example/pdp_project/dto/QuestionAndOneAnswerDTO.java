package com.example.pdp_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAndOneAnswerDTO {
    private Integer id;
    private String title;
    private AnswerDTO answers ;
}
