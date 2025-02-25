package com.example.pdp_project.config;

import com.example.pdp_project.entity.Roles;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.repo.RolesRepository;
import com.example.pdp_project.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DateLoader implements CommandLineRunner {
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public DateLoader(RolesRepository rolesRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Roles> rolesList = rolesRepository.findAll();
//        User user = new User();
//        userRepository.save(user);
    }
}
