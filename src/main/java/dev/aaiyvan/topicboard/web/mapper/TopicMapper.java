package dev.aaiyvan.topicboard.web.mapper;

import dev.aaiyvan.topicboard.domain.model.topic.Topic;
import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.web.dto.topic.TopicRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicResponse;
import dev.aaiyvan.topicboard.web.dto.topic.TopicUpdateRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TopicMapper {

    Topic toTopic(TopicRequest topicRequest);

    TopicResponse toResponse(Topic topic);

}
