package dev.aaiyvan.topicboard.service.user;

import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserResponse> getAll();

    UserResponse getInfo(UUID id);

    User get(UUID id);

    UserResponse save(UserRequest userRequest);

    UserResponse update(UserRequest userRequest, UUID id);

    void delete(UUID id);

}
