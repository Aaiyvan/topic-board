package dev.aaiyvan.topicboard.web.dto.message;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageUpdateRequest {

    @NotNull
    UUID messageId;

    @NotNull
    String text;

}
