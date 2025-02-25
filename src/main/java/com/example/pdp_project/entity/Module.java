package com.example.pdp_project.entity;

import com.example.pdp_project.base.BaseEntity;
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
@Table(name = "modules")
public class Module extends BaseEntity {

    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    private Course course;
    @OneToMany(mappedBy = "module")
    private List<Question> questions = new ArrayList<>();

}

