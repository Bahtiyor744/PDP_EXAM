package com.example.pdp_project.service;

import com.example.pdp_project.dto.UserDTO;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.mapper.UserMapper;
import com.example.pdp_project.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

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

    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.toUserMap(userDTO);
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
        System.out.println("serviceda user to dto method : " + user);
        UserDTO userDTO = userMapper.toUserMapDto(user);
        System.out.println(userDTO);
        return userDTO;
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}
