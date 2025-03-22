package com.example.pdp_project.security;

import com.example.pdp_project.entity.User;
import com.example.pdp_project.repo.UserRepository;
import com.example.pdp_project.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final TokenService jwtProvider;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");
        String firstName = oAuth2User.getAttribute("given_name");
        String lastName = oAuth2User.getAttribute("family_name");

        if (email == null) {
            throw new IllegalStateException("Email not found in OAuth provider response");
        }

        // Bazadan foydalanuvchini qidiramiz
       User user = userRepository.findByEmail(email);
        if (user == null) {
            User newUser = new User();
            String defaultPassword = "123456";
            newUser.setEmail(email);
            newUser.setPassword(defaultPassword);
            newUser.setRoles(List.of());
            newUser.setFirstName(firstName != null ? firstName : "Unknown");
            newUser.setLastName(lastName != null ? lastName : "Unknown");
            user = userRepository.save(newUser);
        }

        // Agar foydalanuvchi bazada mavjud bo'lsa, JWT token yaratamiz
        String jwtToken = jwtProvider.generateToken(user);
        System.out.println(jwtToken);
        // Foydalanuvchini yopiq URL (masalan, /panel) ga yo'naltiramiz
        response.sendRedirect("/user");
    }
}
