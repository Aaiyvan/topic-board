package dev.aaiyvan.topicboard.service.topic.impl;

import dev.aaiyvan.topicboard.domain.exception.InvalidArgumentException;
import dev.aaiyvan.topicboard.domain.exception.MessageNotFoundException;
import dev.aaiyvan.topicboard.domain.exception.TopicNotFoundException;
import dev.aaiyvan.topicboard.domain.model.message.Message;
import dev.aaiyvan.topicboard.domain.model.topic.Topic;
import dev.aaiyvan.topicboard.repository.MessageRepository;
import dev.aaiyvan.topicboard.repository.TopicRepository;
import dev.aaiyvan.topicboard.service.topic.TopicService;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.message.MessageUpdateRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicResponse;
import dev.aaiyvan.topicboard.web.dto.topic.TopicUpdateRequest;
import dev.aaiyvan.topicboard.web.mapper.MessageMapper;
import dev.aaiyvan.topicboard.web.mapper.TopicMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;
    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;

    @Override
    public Topic get(
            final UUID topicId
    ) {
        return topicRepository.findById(topicId)
                .orElseThrow(TopicNotFoundException::new);
    }

    @Override
    public TopicResponse createMessage(
            final MessageRequest messageRequest,
            final UUID topicId
    ) {
        Topic existingTopic = get(topicId);
        Message message = messageMapper.toMessage(messageRequest);
        existingTopic.getMessages().add(message);

        messageRepository.save(message);
        log.info("Saving message with id: {}", message.getId());

        return topicMapper.toResponse(existingTopic);
    }

    @Override
    public List<MessageResponse> getAllMessagesByTopicId(
            final UUID topicId
    ) {
        return messageMapper.toResponse(messageRepository.findAllMessagesByTopicId(topicId));
    }

    @Override
    public void deleteTopic(
            final UUID topicId
    ) {
        topicRepository.deleteById(topicId);
    }

    @Override
    public TopicResponse updateMessage(
            final MessageUpdateRequest messageUpdateRequest,
            final UUID topicId
    ) {
        Topic existingTopic = get(topicId);

        Message topicMessage = messageRepository.findById(messageUpdateRequest.getMessageId())
                .orElseThrow(MessageNotFoundException::new);
        topicMessage.setText(messageUpdateRequest.getText());

        messageRepository.save(topicMessage);
        log.info("Updating message with id: {}", topicMessage.getId());
        topicRepository.save(existingTopic);
        log.info("Updating topic with id: {}", existingTopic.getId());

        return topicMapper.toResponse(existingTopic);
    }

    @Override
    public TopicResponse updateTopic(
            final TopicUpdateRequest topicUpdateRequest,
            final UUID topicId
    ) {
        Topic existingTopic = get(topicId);
        existingTopic.setTitle(topicUpdateRequest.getTitle());

        topicRepository.save(existingTopic);
        log.info("Updating topic with id: {}", existingTopic.getId());

        return topicMapper.toResponse(existingTopic);
    }

    @Override
    public List<TopicResponse> getAllTopics() {
        return topicMapper.toResponse(topicRepository.findAll());
    }

    @Override
    public TopicResponse createTopic(
            final TopicRequest topicRequest
    ) {
        if (topicRequest.getMessageRequest() == null) {
            throw new InvalidArgumentException("Topic must contains a message.");
        }

        Message topicMessage = messageMapper.toMessage(topicRequest.getMessageRequest());
        Topic topic = topicMapper.toTopic(topicRequest);
        topic.getMessages().add(topicMessage);

        messageRepository.save(topicMessage);
        log.info("Saving topic with id: {}", topic.getId());
        topicRepository.save(topic);
        log.info("Saving message with id: {}", topicMessage.getId());

        return topicMapper.toResponse(topic);
    }

}
