package dev.aaiyvan.topicboard.web.mapper;

import dev.aaiyvan.topicboard.domain.model.message.Message;
import dev.aaiyvan.topicboard.domain.model.topic.Topic;
import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.message.MessageUpdateRequest;
import dev.aaiyvan.topicboard.web.dto.topic.TopicUpdateRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    Message toMessage(MessageRequest messageRequest);

    MessageResponse toResponse(Message message);

    List<MessageResponse> toResponse(List<Message> messages);

}
