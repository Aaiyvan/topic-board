package dev.aaiyvan.topicboard.web.controller;

import dev.aaiyvan.topicboard.service.topic.TopicService;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.message.MessageUpdateRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicResponse;
import dev.aaiyvan.topicboard.web.dto.topic.TopicUpdateRequest;
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
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public ResponseEntity<Page<TopicResponse>> getAllTopics(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit
    ) {
        return ResponseEntity.ok(topicService.getAllTopics(offset, limit));
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<Page<MessageResponse>> getAllMessagesByTopicId (
            final @PathVariable UUID topicId,
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit
    ) {
        return ResponseEntity.ok(topicService.getAllMessagesByTopicId(topicId, offset, limit));
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
