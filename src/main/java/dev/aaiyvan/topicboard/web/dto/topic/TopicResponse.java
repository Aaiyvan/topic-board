package dev.aaiyvan.topicboard.web.dto.topic;

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
@Schema(description = "Response after TopicRequest")
public class TopicResponse {

    String title;

    List<MessageResponse> messages;

}
