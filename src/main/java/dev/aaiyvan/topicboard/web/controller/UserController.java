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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAllUsers(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) final Integer offset,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) final Integer limit
    ) {
        return ResponseEntity.ok(userService.getAll(offset, limit));
    }

    @GetMapping("/{userId}/messages")
    public ResponseEntity<Page<MessageResponse>> getAllMessages(
            final @PathVariable UUID userId,
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) final Integer offset,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) final Integer limit
    ) {
        return ResponseEntity.ok(messageService.getAllByUserId(userId, offset, limit));
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<UserResponse> getInfoUser (
            final @PathVariable UUID id
    ) {
        return ResponseEntity.ok(userService.getInfo(id));
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
