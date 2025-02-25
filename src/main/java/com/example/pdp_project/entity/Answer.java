package com.example.pdp_project.entity;

import com.example.pdp_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answer extends BaseEntity {
    private Integer id;
    private String title;
    private Boolean correct;
    @ManyToOne
    private Question question;
    private Integer mark;
}

