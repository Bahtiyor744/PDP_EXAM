package com.example.pdp_project.dto;

import lombok.Value;

@Value
public class QuestionDTO {
    private Integer id;
    private String text;
    private Integer moduleId;
}
