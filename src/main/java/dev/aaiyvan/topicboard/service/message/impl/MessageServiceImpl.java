package dev.aaiyvan.topicboard.service.message.impl;

import dev.aaiyvan.topicboard.domain.exception.InvalidArgumentException;
import dev.aaiyvan.topicboard.domain.exception.MessageNotFoundException;
import dev.aaiyvan.topicboard.domain.model.message.Message;
import dev.aaiyvan.topicboard.repository.MessageRepository;
import dev.aaiyvan.topicboard.service.message.MessageService;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public List<MessageResponse> getAllByUserId (
            final UUID userId
    ) {
        return messageMapper.toResponse(messageRepository.findAllByUserId(userId));
    }

    @Override
    public void deleteMessage(
            final UUID messageId
    ) {
        messageRepository.deleteById(messageId);
    }

}
