package dev.aaiyvan.topicboard.web.mapper;

import dev.aaiyvan.topicboard.domain.model.message.Message;
import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    Message toMessage(MessageResponse messageResponse);

    Message toMessage(MessageRequest messageRequest);

    MessageResponse toResponse(Message message);

    MessageRequest toRequest(Message message);

    List<MessageResponse> toResponse(List<Message> messages);

}
