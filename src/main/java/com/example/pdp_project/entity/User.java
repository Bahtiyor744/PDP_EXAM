package com.example.pdp_project.entity;

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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;
    @OneToOne
    private Attachment attachment;
    private Integer rating;
    @ManyToMany
    private List<Course> courses = new ArrayList<>();

}