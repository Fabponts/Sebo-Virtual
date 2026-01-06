package com.fabpont.dev.sebo_virtual.controllers;

import com.fabpont.dev.sebo_virtual.DTO.UserLoginDTO;
import com.fabpont.dev.sebo_virtual.DTO.UserRegisterDTO;
import com.fabpont.dev.sebo_virtual.entities.User;
import com.fabpont.dev.sebo_virtual.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,  AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginDTO> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(userLoginDTO.email(), userLoginDTO.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterDTO> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(userRegisterDTO.password()));
        user.setEmail(userRegisterDTO.email());
        user.setName(userRegisterDTO.name());
        user.setPhoneNumber(userRegisterDTO.phoneNumber());
        user.setAddress(userRegisterDTO.address());

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userRegisterDTO);

    }
}
