package dev.aaiyvan.topicboard.web.controller;

import dev.aaiyvan.topicboard.service.message.MessageService;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@Tag(
        name = "Message Controller",
        description = "Message API"
)
public class MessageController {

    private final MessageService messageService;

    @DeleteMapping("/{messageId}")
    @PreAuthorize("@cse.canAccessMessage(#messageId)")
    public void deleteMessage(
            @PathVariable final UUID messageId
    ){
        messageService.deleteMessage(messageId);
    }



}
