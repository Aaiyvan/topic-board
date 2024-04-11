package dev.aaiyvan.topicboard.web.dto.message;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "MessageUpdateRequest DTO")
public class MessageUpdateRequest {

    @Schema(
            description = "Message ID",
            example = "44308ba1-0917-41ec-a333-9dce944d71bc"
    )
    @NotNull(
            message = "Message ID must be not null."
    )
    UUID messageId;

    @Schema(
            description = "Text"
    )
    @NotNull(
            message = "Text must be not null."
    )
    @Length(
            max = 255,
            message = "Text length must be smaller than 255 symbols."
    )
    String text;

}
