package dev.aaiyvan.topicboard.web.dto.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Response after MessageRequest")
public class MessageResponse {

    String authorName;

    String text;

    LocalDateTime creationDate;

}
