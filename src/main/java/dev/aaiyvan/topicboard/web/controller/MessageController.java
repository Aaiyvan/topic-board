package dev.aaiyvan.topicboard.web.controller;

import dev.aaiyvan.topicboard.service.message.MessageService;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<MessageResponse>> getAllMessages()
    {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<MessageResponse> getInfoMessage (
            final @PathVariable UUID id
    ) {
        return ResponseEntity.ok(messageService.getInfo(id));
    }

    @PostMapping("/create")
    public ResponseEntity<MessageResponse> createMessage (
            final @RequestBody @Valid MessageRequest messageRequest
    ) {
        return ResponseEntity.ok(messageService.createMessage(messageRequest));
    }



}
