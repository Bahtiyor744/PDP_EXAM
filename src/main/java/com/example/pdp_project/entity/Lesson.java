package com.example.pdp_project.entity;

import com.example.pdp_project.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Lesson extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    private Module module;
    @OneToMany(mappedBy = "lesson")
    private List<Question> questions = new ArrayList<>();
}
