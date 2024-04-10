package dev.aaiyvan.topicboard.web.dto.user;

import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    String name;

    String username;

    List<MessageResponse> messages;
}
