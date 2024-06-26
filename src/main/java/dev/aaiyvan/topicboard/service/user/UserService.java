package dev.aaiyvan.topicboard.service.user;

import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponse getInfo(UUID id);

    User get(UUID id);

    UserResponse update(UserRequest userRequest, UUID id);

    void delete(UUID id);

    User getByUsername(String username);

    boolean existsByUsername(String username);

    UserResponse createUser(UserRequest userRequest);

    Page<UserResponse> getAll(Integer offset, Integer limit);

    boolean isMessageOwner(UUID userId, UUID messageId);

}
