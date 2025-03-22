package com.example.pdp_project.entity;

import com.example.pdp_project.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    @NotBlank(message = "First Name is required")
    private String firstName;
    @NotBlank(message = "Last Name is required")
    private String lastName;
    @Email(message = "Incorrect email")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;
    @OneToOne
    private Attachment attachment;
    private String code;
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public User(String firstName, String lastName, String email, String password, List<Roles> roles, Attachment attachment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.attachment = attachment;
    }
}