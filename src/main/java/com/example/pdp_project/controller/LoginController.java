package com.example.pdp_project.controller;

import com.example.pdp_project.dto.EmailDTO;
import com.example.pdp_project.dto.LoginDTO;
import com.example.pdp_project.dto.UserDTO;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.security.AuthenticationService;
import com.example.pdp_project.service.UserService;
import com.example.pdp_project.service.VerificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Validated
public class LoginController {
    private final UserService userService;
    private final VerificationService verificationService;
    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<?> loginPage(@RequestBody @Valid EmailDTO emailDTO) {
        User user = userService.findByEmailAndPassword(emailDTO);
        if (user != null) {
            verificationService.sendEmail(emailDTO.getEmail());
            return ResponseEntity.ok("Code sent to email");
        }
        return ResponseEntity.status(404).body("User not found");
    }

    @PostMapping("/code")
    public ResponseEntity<?> verificationCode(@RequestBody @Valid LoginDTO loginDTO) {
        return authenticationService.verifyAndAuthenticate(loginDTO);
    }
}
