package dev.aaiyvan.topicboard.service.topic;

import dev.aaiyvan.topicboard.domain.model.topic.Topic;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.message.MessageUpdateRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicResponse;
import dev.aaiyvan.topicboard.web.dto.topic.TopicUpdateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface TopicService {

    TopicResponse createTopic(TopicRequest topicRequest);

    List<TopicResponse> getAllTopics();

    Topic get(UUID topicId);

    TopicResponse createMessage(MessageRequest messageRequest, UUID topicId);

    List<MessageResponse> getAllMessagesByTopicId(UUID topicId);

    void deleteTopic(UUID topicId);

    TopicResponse updateMessage(MessageUpdateRequest messageUpdateRequest, UUID topicId);

    TopicResponse updateTopic(TopicUpdateRequest topicUpdateRequest, UUID topicId);

}
