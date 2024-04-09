package dev.aaiyvan.topicboard.web.dto.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageResponse {

    String authorName;

    String text;

    LocalDateTime creationDate;

}
