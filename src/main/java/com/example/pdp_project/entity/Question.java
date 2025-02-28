package com.example.pdp_project.entity;

import com.example.pdp_project.base.BaseEntity;
import com.example.pdp_project.enums.Level;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "questions")
public class Question extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Level level;
    private String title;
    @ManyToOne
    private Lesson lesson;
    @OneToMany(mappedBy = "answer")
    private List<Answer> answers = new ArrayList<>();

}

