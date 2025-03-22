package com.example.pdp_project.service;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.repo.UserRepository;
import com.example.pdp_project.service.CustomOAuth2User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String email = oAuth2User.getAttribute("email");
        String firstName = oAuth2User.getAttribute("given_name");
        String lastName = oAuth2User.getAttribute("family_name");

        if(email == null) {
            throw new OAuth2AuthenticationException("Email not found from OAuth2 provider");
        }

        User user = userRepository.findByEmail(email);
        if(user == null) {
            User newUser = new User();
            String defaultPassword = "123456";
            newUser.setEmail(email);
            newUser.setPassword(defaultPassword);
            newUser.setRoles(List.of());
            newUser.setFirstName(firstName != null ? firstName : "Unknown");
            newUser.setLastName(lastName != null ? lastName : "Unknown");
            user = userRepository.save(newUser);
        }

        // Agar foydalanuvchi mavjud bo'lsa, uni CustomOAuth2User orqali qaytaramiz,
        // shunda SecurityConfig da belgilangan yopiq URL-larga kirish ruxsat etiladi.
        return new CustomOAuth2User(oAuth2User, "");
    }
}
