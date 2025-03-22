package com.example.pdp_project.entity;

import com.example.pdp_project.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String title;
    @ManyToOne
    private Lesson lesson;
    @OneToMany
    private List<Answer> answers = new ArrayList<>();
}

