package dev.aaiyvan.topicboard.web.dto.topic;

import dev.aaiyvan.topicboard.web.dto.message.MessageRequest;
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
@Schema(description = "TopicRequest DTO")
public class TopicRequest {

    @Schema(
            description = "Topic",
            example = "First Topic"
    )
    @NotNull(
            message = "Title must be not null."
    )
    @Length(
            max = 255,
            message = "Title length must be smaller than 255 symbols."
    )
    String title;

    @Schema(
            description = "First message in topic"
    )
    @NotNull(
            message = "Message must be not null."
    )
    MessageRequest messageRequest;

}
