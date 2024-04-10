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
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @DeleteMapping("/{messageId}")
    public void deleteMessage(
            @PathVariable final UUID messageId
    ){
        messageService.deleteMessage(messageId);
    }



}
