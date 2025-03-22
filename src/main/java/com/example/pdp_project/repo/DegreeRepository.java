package com.example.pdp_project.repo;

import com.example.pdp_project.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {
}