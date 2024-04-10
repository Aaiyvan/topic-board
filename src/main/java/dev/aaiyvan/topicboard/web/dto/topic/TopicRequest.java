package dev.aaiyvan.topicboard.web.dto.topic;

import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicRequest {

    @NotNull
    String title;

    @NotNull
    MessageRequest messageRequest;

}
