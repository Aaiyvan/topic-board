package dev.aaiyvan.topicboard.web.dto.topic;

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
@Schema(description = "TopicUpdateRequest DTO")
public class TopicUpdateRequest {

    @Schema(
            description = "Topic"
    )
    @NotNull(
            message = "Title must be not null."
    )
    @Length(
            max = 255,
            message = "Title length must be smaller than 255 symbols."
    )
    String title;

}
