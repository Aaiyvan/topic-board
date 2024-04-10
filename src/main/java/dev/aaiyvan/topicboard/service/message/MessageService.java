package dev.aaiyvan.topicboard.service.message;

import dev.aaiyvan.topicboard.domain.model.message.Message;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;

import java.util.List;
import java.util.UUID;

public interface MessageService {

    List<MessageResponse> getAllByUserId(UUID userId);

    void deleteMessage(UUID messageId);
}
