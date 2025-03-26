package com.example.pdp_project.entity;

import com.example.pdp_project.base.BaseEntity;
import com.example.pdp_project.enums.Level;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Step extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Level step;
}
