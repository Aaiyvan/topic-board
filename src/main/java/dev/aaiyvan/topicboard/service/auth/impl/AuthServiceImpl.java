package dev.aaiyvan.topicboard.service.auth.impl;

import dev.aaiyvan.topicboard.domain.exception.ResourceAlreadyExistsException;
import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.service.auth.AuthService;

import dev.aaiyvan.topicboard.service.user.UserService;
import dev.aaiyvan.topicboard.web.dto.auth.LoginRequest;
import dev.aaiyvan.topicboard.web.dto.auth.LoginResponse;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import dev.aaiyvan.topicboard.web.mapper.UserMapper;
import dev.aaiyvan.topicboard.web.security.jwt.JwtProperties;
import dev.aaiyvan.topicboard.web.security.jwt.TokenType;
import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenService tokenService;
    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(
            final LoginRequest request
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        LoginResponse response = new LoginResponse();
        response.setAccess(
                tokenService.create(
                        TokenParameters.builder(
                                        request.getUsername(),
                                        TokenType.ACCESS.name(),
                                        jwtProperties.getAccess()
                                )
                                .build()
                )
        );
        response.setRefresh(
                tokenService.create(
                        TokenParameters.builder(
                                        request.getUsername(),
                                        TokenType.REFRESH.name(),
                                        jwtProperties.getRefresh()
                                )
                                .build()
                )
        );
        return response;
    }

    @Override
    public UserResponse register(
            final UserRequest userRequest
    ) {
        if (userService.existsByUsername(userRequest.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userService.createUser(userRequest);
    }

}
