package com.example.pdp_project.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<Roles, UUID> {
}