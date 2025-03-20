package com.example.pdp_project.security;

import com.example.pdp_project.entity.User;
import com.example.pdp_project.repo.UserRepository;
import com.example.pdp_project.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final TokenService jwtProvider;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");

        if (email == null) {
            throw new IllegalStateException("Email not found in OAuth provider response");
        }

        // Bazadan foydalanuvchini qidiramiz
        User user = userRepository.findByEmail(email);
        if (user == null) {
            // Security context ni tozalash orqali foydalanuvchini anonim qilish
            SecurityContextHolder.clearContext();
            response.sendRedirect("/login?error=nouser");
            return;
        }

        // Agar foydalanuvchi bazada mavjud bo'lsa, JWT token yaratamiz
        String jwtToken = jwtProvider.generateToken(user);

        // Foydalanuvchini yopiq URL (masalan, /panel) ga yo'naltiramiz
        response.sendRedirect("/panel?token=" + jwtToken);
    }
}
