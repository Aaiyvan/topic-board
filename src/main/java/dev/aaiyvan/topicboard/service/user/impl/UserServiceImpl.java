package dev.aaiyvan.topicboard.service.user.impl;

import dev.aaiyvan.topicboard.domain.exception.InvalidArgumentException;
import dev.aaiyvan.topicboard.domain.exception.UserNotFoundException;
import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.repository.UserRepository;
import dev.aaiyvan.topicboard.service.user.UserService;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import dev.aaiyvan.topicboard.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAll() {
        return userMapper.toResponse(userRepository.findAll());
    }

    @Override
    public UserResponse getInfo(
            final UUID id
    ) {
        return userMapper.toResponse(get(id));
    }

    @Override
    public User get(
            final UUID id
    ) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    @Transactional
    public UserResponse update(
            final UserRequest userRequest,
            final UUID id
    ) {
        User existingUser = get(id);
        User updatedUser = userMapper.toUser(userRequest);

        log.info("Updating user with id: {}", existingUser.getId());
        userRepository.save(updatedUser);

        return userMapper.toResponse(updatedUser);
    }

    @Override
    @Transactional
    public void delete(
            final UUID id
    ) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByUsername(
            final String username
    ) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(
            final String username
    ) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserResponse createUser(
            final UserRequest userRequest
    ) {
        User user = userMapper.toUser(userRequest);

        if (user == null) {
            throw new InvalidArgumentException("User cannot be null");
        }

        userRepository.save(user);
        log.info("Saving user with id: {}", user.getId());

        return userMapper.toResponse(user);

    }

}
