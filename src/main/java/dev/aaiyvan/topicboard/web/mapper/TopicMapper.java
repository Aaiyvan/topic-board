package dev.aaiyvan.topicboard.web.mapper;

import dev.aaiyvan.topicboard.domain.model.topic.Topic;
import dev.aaiyvan.topicboard.web.dto.topic.TopicRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicMapper {

    Topic toTopic(TopicResponse topicResponse);

    Topic toTopic(TopicRequest topicRequest);

    TopicResponse toResponse(Topic topic);

    TopicRequest toRequest(Topic topic);

}
