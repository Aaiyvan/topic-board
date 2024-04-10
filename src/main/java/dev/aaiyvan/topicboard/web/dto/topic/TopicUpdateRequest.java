package dev.aaiyvan.topicboard.web.dto.topic;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicUpdateRequest {

    @NotNull
    String title;

}
