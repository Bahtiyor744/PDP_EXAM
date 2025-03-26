package com.example.pdp_project.service;

import com.example.pdp_project.dto.EmailDTO;
import com.example.pdp_project.dto.RegisterDTO;
import com.example.pdp_project.dto.UserDTO;
import com.example.pdp_project.dto.UserUpdateDTO;
import com.example.pdp_project.entity.Attachment;
import com.example.pdp_project.entity.Roles;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.mapper.UserMapper;
import com.example.pdp_project.repo.AttachmentRepository;
import com.example.pdp_project.repo.RolesRepository;
import com.example.pdp_project.repo.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.pdp_project.enums.UserRole.USER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final AttachmentRepository attachmentRepository;

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toUserMapDto)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::toUserMapDto).orElse(null);
    }

    public UserDTO create(RegisterDTO registerDTO) {
        User user = userMapper.toUserMap(registerDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Roles role = rolesRepository.findByRole(USER);
        List<Roles> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        user = userRepository.save(user);
        return userMapper.toUserMapDto(user);
    }

    public UserDTO update(Integer id, UserDTO userDTO) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User user1 = userMapper.toUserMap(userDTO);
            user1.setId(id);
            userRepository.save(user1);
            return userMapper.toUserMapDto(user1);
        }
        return null;
    }

    public UserDTO userToDTO(User user) {
        UserDTO userDTO = userMapper.toUserMapDto(user);
        System.out.println(userDTO);
        return userDTO;
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public User findByEmailAndPassword(EmailDTO loginDTO) {
        return userRepository.findByEmail(loginDTO.getEmail());
    }

    public UserDTO updateUser(@Valid UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(userUpdateDTO.getId()).orElseThrow();
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        user.setPassword(userUpdateDTO.getPassword());
        Attachment attachment = attachmentRepository.findById(userUpdateDTO.getAttachmentID()).orElseThrow();
        user.setAttachment(attachment);
        userRepository.save(user);
        return userMapper.toUserMapDto(user);
    }
}
