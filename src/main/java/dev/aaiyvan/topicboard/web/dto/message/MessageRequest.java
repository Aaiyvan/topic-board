package dev.aaiyvan.topicboard.web.dto.message;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "MessageRequest DTO")
public class MessageRequest {

    @Schema(
            description = "Author username",
            example = "johnDoe"
    )
    @NotNull(
            message = "Author name must be not null."
    )
    @Length(
            max = 255,
            message = "Author name length must be smaller than 255 symbols."
    )
    String authorName;

    @Schema(
            description = "Text",
            example = "JohnDoe message1"
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
