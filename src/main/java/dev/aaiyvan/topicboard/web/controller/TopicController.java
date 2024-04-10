package dev.aaiyvan.topicboard.web.controller;

import dev.aaiyvan.topicboard.service.topic.TopicService;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.message.MessageUpdateRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicResponse;
import dev.aaiyvan.topicboard.web.dto.topic.TopicUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public ResponseEntity<List<TopicResponse>> getAllTopics() {
        return ResponseEntity.ok(topicService.getAllTopics());
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<List<MessageResponse>> getAllMessagesByTopicId (
            final @PathVariable UUID topicId
    ) {
        return ResponseEntity.ok(topicService.getAllMessagesByTopicId(topicId));
    }

    @PostMapping("/create")
    public ResponseEntity<TopicResponse> createTopic(
            @RequestBody @Valid TopicRequest topicRequest
    ) {
        return ResponseEntity.ok(topicService.createTopic(topicRequest));
    }

    @PostMapping("/{topicId}/message")
    public ResponseEntity<TopicResponse> createMessageInTopic(
            @RequestBody @Valid MessageRequest messageRequest,
            @PathVariable UUID topicId
    ) {
        return ResponseEntity.ok(topicService.createMessage(messageRequest, topicId));
    }

    @PutMapping("/{topicId}")
    public ResponseEntity<TopicResponse> updateTopic(
            @RequestBody @Valid TopicUpdateRequest topicUpdateRequest,
            @PathVariable UUID topicId
    ) {
        return ResponseEntity.ok(topicService.updateTopic(topicUpdateRequest, topicId));
    }


    @PutMapping("/{topicId}/message")
    public ResponseEntity<TopicResponse> updateMessageInTopic(
            @RequestBody @Valid MessageUpdateRequest messageUpdateRequest,
            @PathVariable UUID topicId
    ) {
        return ResponseEntity.ok(topicService.updateMessage(messageUpdateRequest, topicId));
    }

    @DeleteMapping("/{topicId}")
    public void deleteTopic(
            @PathVariable final UUID topicId
    ){
        topicService.deleteTopic(topicId);
    }

}
