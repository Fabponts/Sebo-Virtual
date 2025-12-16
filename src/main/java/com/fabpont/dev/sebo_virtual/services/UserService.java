package com.fabpont.dev.sebo_virtual.services;

import com.fabpont.dev.sebo_virtual.DTO.UserRegisterDTO;
import com.fabpont.dev.sebo_virtual.entities.User;
import com.fabpont.dev.sebo_virtual.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setName(userRegisterDTO.name());
        user.setEmail(userRegisterDTO.email());
        user.setPassword(userRegisterDTO.password());
        user.setPhoneNumber(userRegisterDTO.phoneNumber());
        user.setAddress(userRegisterDTO.address());
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Long user_id) {
        if (userRepository.existsById(user_id)) {
            return userRepository.findById(user_id);
        } else{
            throw new RuntimeException("Id user not found: " + user_id);
        }
    }

    public void  deleteUserById(Long user_id) {
        if (userRepository.existsById(user_id)) {
           userRepository.deleteById(user_id);
        }else
        {
            throw new RuntimeException("Id user not found: " + user_id);
        }
    }
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long user_id, UserRegisterDTO userRegisterDTO) {
        if (userRepository.existsById(user_id)) {
            User user = findUserById(user_id).get();
            user.setName(userRegisterDTO.name());
            user.setEmail(userRegisterDTO.email());
            user.setPassword(userRegisterDTO.password());
            user.setPhoneNumber(userRegisterDTO.phoneNumber());
            user.setAddress(userRegisterDTO.address());
            return userRepository.save(user);
        }else {
            throw new RuntimeException("Id user not found: " + user_id);
        }
    }
}
