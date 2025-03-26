package com.example.pdp_project.dto;

import com.example.pdp_project.enums.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor()
public class UsersAnswerDTO {
    @NotNull(message = "User ID is required")
    private Integer currentUserId;
    private Level step = Level.EASY;
    @NotNull(message = "Lesson ID is required")
    private Integer lessonId;
    @NotNull(message = "Answers is required")
    private List<QuestionAndOneAnswerDTO> questionAndOneAnswer;
}
