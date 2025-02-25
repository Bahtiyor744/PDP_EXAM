package com.example.pdp_project.entity;

import com.example.pdp_project.enums.Level;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Level level;
    private String title;
    @ManyToOne
    private Module module;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();
}

