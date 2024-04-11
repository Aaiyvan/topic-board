package dev.aaiyvan.topicboard.web.controller;

import dev.aaiyvan.topicboard.service.message.MessageService;
import dev.aaiyvan.topicboard.service.user.UserService;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(
        name = "User Controller",
        description = "Client API"
)
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

    @GetMapping("/info/{userId}")
    public ResponseEntity<UserResponse> getInfoUser (
            final @PathVariable UUID userId
    ) {
        return ResponseEntity.ok(userService.getInfo(userId));
    }

    @PutMapping("/{userId}")
    @PreAuthorize("@cse.canAccessUser(#userId)")
    public ResponseEntity<UserResponse> updateUser (
            @RequestBody final UserRequest userRequest,
            @PathVariable final UUID userId
    ) {
        return ResponseEntity.ok(userService.update(userRequest, userId));
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("@cse.canAccessUser(#userId)")
    public ResponseEntity<String> deleteUser (
            final @PathVariable UUID userId
    ) {
        userService.delete(userId);
        return ResponseEntity.ok("User with id: " + userId + " was deleted.");
    }


}
