package com.projeto.climate.service;

import com.projeto.climate.dto.UserDTO;
import com.projeto.climate.entity.User;
import com.projeto.climate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());

        // Senha em texto puro
        user.setPassword(userDTO.getPassword());

        user.setRole(userDTO.getRole());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
