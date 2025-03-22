package com.example.pdp_project.security;

import com.example.pdp_project.dto.LoginDTO;
import com.example.pdp_project.dto.UserDTO;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.repo.UserRepository;
import com.example.pdp_project.service.TokenService;
import com.example.pdp_project.service.UserService;
import com.example.pdp_project.service.VerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final VerificationService verificationService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserService userService;


    public ResponseEntity<?> verifyAndAuthenticate(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        if (!verificationService.verifyCode(loginDTO.getEmail(), loginDTO.getCode())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid verification code");
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        User authenticatedUser = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(authenticatedUser);
        UserDTO userDTO = userService.userToDTO(authenticatedUser);

        Map<String, Object> response = new HashMap<>();
        response.put("Authorization", token);
        response.put("user", userDTO);
        return ResponseEntity.ok(response);
    }
}
