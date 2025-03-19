package com.example.pdp_project.config;

import com.example.pdp_project.entity.Roles;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.enums.UserRole;
import com.example.pdp_project.repo.RolesRepository;
import com.example.pdp_project.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor

public class DateLoader implements CommandLineRunner {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (ddlAuto.equals("create")) {
            Roles role1 = new Roles(UserRole.SUPER_ADMIN);
            Roles role2 = new Roles(UserRole.ADMIN);
            Roles role3 = new Roles(UserRole.USER);
            rolesRepository.save(role1);
            rolesRepository.save(role2);
            rolesRepository.save(role3);
            List<Roles> rolesList = rolesRepository.findAll();
            User user = new User("Admin", "Admin", "bahhtee7444@mail.ru", passwordEncoder.encode("1"), rolesList, null);
            userRepository.save(user);
        }
    }
}
