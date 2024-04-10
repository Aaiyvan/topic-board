package dev.aaiyvan.topicboard.web.controller;

import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.service.auth.AuthService;
import dev.aaiyvan.topicboard.web.dto.auth.LoginRequest;
import dev.aaiyvan.topicboard.web.dto.auth.LoginResponse;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import dev.aaiyvan.topicboard.web.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public UserResponse register(
            @RequestBody @Valid final UserRequest userRequest
    ) {
        return authService.register(userRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody @Valid final LoginRequest user
    ) {
        return authService.login(user);
    }

}