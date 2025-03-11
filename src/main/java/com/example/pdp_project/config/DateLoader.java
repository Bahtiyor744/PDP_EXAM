package com.example.pdp_project.config;

import com.example.pdp_project.entity.Roles;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.repo.RolesRepository;
import com.example.pdp_project.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
@RequiredArgsConstructor

public class DateLoader implements CommandLineRunner {
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Roles> rolesList = rolesRepository.findAll();
        User user = new User("Admin", "Admin", "admin@gmail.com", passwordEncoder.encode("1"), rolesList, null);
        userRepository.save(user);
    }
}
