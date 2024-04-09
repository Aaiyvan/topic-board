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

//    @GetMapping("/{topicId}/messages")
//    public ResponseEntity<List<MessageResponse>> getAllMessagesByTopicId (
//            final @PathVariable UUID topicId
//    ) {
//        return ResponseEntity.ok(topicService.getAllByTopicId(topicId));
//    }

    @GetMapping("/info/{id}")
    public ResponseEntity<UserResponse> getInfoUser (
            final @PathVariable UUID id
    ) {
        return ResponseEntity.ok(userService.getInfo(id));
    }

//    @PostMapping("/{userId}/topics/create")
//    public ResponseEntity<TopicResponse> createTopicByUserId (
//            final @Valid @RequestBody TopicRequest topicRequest,
//            final @PathVariable UUID userId
//    ) {
//        return ResponseEntity.ok(topicService.create(userId, topicRequest));
//    }

    @PostMapping("/{userId}/messages/create")
    public ResponseEntity<MessageResponse> createMessageByUserId (
            final @Valid @RequestBody MessageRequest messageRequest,
            final @PathVariable UUID userId
    ) {
        return ResponseEntity.ok(messageService.createMessageByUserId(userId, messageRequest));
    }

    @PutMapping("/{userId}/messages/update")
    public ResponseEntity<MessageResponse> updateMessageByUserId (
            final @Valid @RequestBody MessageRequest messageRequest,
            final @PathVariable UUID userId
    ) {
        return ResponseEntity.ok(messageService.update(userId, messageRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser (
            final @RequestBody UserRequest userRequest,
            final @PathVariable UUID id
    ) {
        return ResponseEntity.ok(userService.update(userRequest, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser (
            final @PathVariable UUID id
    ) {
        userService.delete(id);
        return ResponseEntity.ok("User with id: " + id + " was deleted");
    }


}
