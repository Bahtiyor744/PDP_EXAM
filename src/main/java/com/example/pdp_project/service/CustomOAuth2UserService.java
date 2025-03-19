package com.example.pdp_project.service;





import com.example.pdp_project.entity.User;
import com.example.pdp_project.repo.UserRepository;
import com.example.pdp_project.service.CustomOAuth2User;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

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

        if(email == null) {
            throw new OAuth2AuthenticationException("Email not found from OAuth2 provider");
        }

        // Bazadagi foydalanuvchini qidirish
        User user = userRepository.findByEmail(email);
        if(user == null){
            // Agar foydalanuvchi bazada mavjud bo'lmasa, autentifikatsiyani rad etamiz.
            throw new OAuth2AuthenticationException("User not registered");
        }

        // Agar foydalanuvchi mavjud bo'lsa, uni CustomOAuth2User orqali qaytaramiz,
        // shunda SecurityConfig da belgilangan yopiq URL-larga kirish ruxsat etiladi.
        return new CustomOAuth2User(oAuth2User, "");
    }
}
