package com.example.pdp_project.repo;

import com.example.pdp_project.entity.Roles;
import com.example.pdp_project.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles findByRole(UserRole user);
}