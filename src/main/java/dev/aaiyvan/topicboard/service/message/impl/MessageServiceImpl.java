package dev.aaiyvan.topicboard.service.message.impl;

import dev.aaiyvan.topicboard.repository.MessageRepository;
import dev.aaiyvan.topicboard.service.message.MessageService;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.mapper.MessageMapper;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public Page<MessageResponse> getAllByUserId (
            final UUID userId,
            @Min(0) final Integer offset,
            @Min(1) @Max(100) final Integer limit
    ) {
        return messageRepository
                .findAllByUserId(userId, PageRequest.of(offset, limit))
                .map(messageMapper::toResponse);
    }

    @Override
    public void deleteMessage(
            final UUID messageId
    ) {
        messageRepository.deleteById(messageId);
    }

}
