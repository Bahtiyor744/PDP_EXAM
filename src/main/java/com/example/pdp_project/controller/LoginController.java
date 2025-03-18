package com.example.pdp_project.controller;

import com.example.pdp_project.dto.LoginDTO;
import com.example.pdp_project.dto.UserDTO;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.service.TokenService;
import com.example.pdp_project.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Validated
public class LoginController {
    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> loginPage(@RequestBody @Valid LoginDTO loginDTO) {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        User user = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(user);
        UserDTO userDTO = userService.userToDTO(user);
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", userDTO);
        return ResponseEntity.ok(response);
    }
}
