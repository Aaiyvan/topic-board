package dev.aaiyvan.topicboard.web.controller;

import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.service.message.MessageService;
import dev.aaiyvan.topicboard.service.topic.TopicService;
import dev.aaiyvan.topicboard.service.user.UserService;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.topic.TopicRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicResponse;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MessageService messageService;
    private final TopicService topicService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{userId}/messages")
    public ResponseEntity<List<MessageResponse>> getAllMessagesByUserId(
            final @PathVariable UUID userId
    ) {
        return ResponseEntity.ok(messageService.getAllByUserId(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(
            final @RequestBody @Valid UserRequest userRequest
    ) {
        return ResponseEntity.ok(userService.save(userRequest));
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<UserResponse> getInfoUser (
            final @PathVariable UUID id
    ) {
        return ResponseEntity.ok(userService.getInfo(id));
    }

    @PostMapping("/topic/create")
    public ResponseEntity<TopicResponse> createTopic (
            @RequestBody @Valid final TopicRequest topicRequest
    ) {
        return ResponseEntity.ok(topicService.createTopic(topicRequest));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserResponse> updateUser (
            final @RequestBody UserRequest userRequest,
            final @PathVariable UUID userId
    ) {
        return ResponseEntity.ok(userService.update(userRequest, userId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser (
            final @PathVariable UUID id
    ) {
        userService.delete(id);
        return ResponseEntity.ok("User with id: " + id + " was deleted");
    }


}
