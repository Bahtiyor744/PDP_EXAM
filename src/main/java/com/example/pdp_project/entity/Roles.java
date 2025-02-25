package com.example.pdp_project.entity;

import com.example.pdp_project.base.BaseEntity;
import com.example.pdp_project.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

public class Roles extends BaseEntity implements GrantedAuthority {
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public String getAuthority() {
        return this.role.name();
    }
}

