package com.example.pdp_project.dto;

import lombok.Value;

@Value
public class AnswerDTO {
    private Integer id;
    private String text;
    private Integer questionId;
}
