package com.example.pdp_project.repo;

import com.example.pdp_project.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
    List<Module> findAllByCourse_Id(Integer courseId);
}