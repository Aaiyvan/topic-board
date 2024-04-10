package dev.aaiyvan.topicboard.service.message;

import dev.aaiyvan.topicboard.domain.model.message.Message;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface MessageService {

    Page<MessageResponse> getAllByUserId(UUID userId, Integer offset, Integer limit);

    void deleteMessage(UUID messageId);
}
