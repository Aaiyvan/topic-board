package dev.aaiyvan.topicboard.service.topic;

import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.topic.TopicRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicResponse;

import java.util.List;
import java.util.UUID;

public interface TopicService {

    TopicResponse create(UUID userId, TopicRequest topicRequest);

    List<MessageResponse> getAllByTopicId(UUID topicId);

}
