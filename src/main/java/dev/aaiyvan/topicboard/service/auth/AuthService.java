package dev.aaiyvan.topicboard.service.auth;

import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.web.dto.auth.LoginRequest;
import dev.aaiyvan.topicboard.web.dto.auth.LoginResponse;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    UserResponse register(UserRequest userRequest);
}
