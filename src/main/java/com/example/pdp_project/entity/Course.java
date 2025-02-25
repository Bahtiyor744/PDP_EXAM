package com.example.pdp_project.entity;

import com.example.pdp_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Setter
public class Course extends BaseEntity {
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "course")
    private List<Module> modules = new ArrayList<>();

}
