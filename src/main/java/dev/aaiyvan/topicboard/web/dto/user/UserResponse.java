package dev.aaiyvan.topicboard.web.dto.user;

import dev.aaiyvan.topicboard.web.dto.message.MessageResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Response after UserRequest")
public class UserResponse {

    String name;

    String username;

    List<MessageResponse> messages;
}
