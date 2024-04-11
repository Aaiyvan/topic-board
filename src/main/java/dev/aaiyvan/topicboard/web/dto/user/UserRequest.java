package dev.aaiyvan.topicboard.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Schema(description = "UserRequest DTO")
public class UserRequest {

    @Schema(
            description = "User Name",
            example = "John Doe"
    )
    @NotNull(
            message = "Name must be not null."
    )
    @Length(
            max = 255,
            message = "Name length must be smaller than 255 symbols."
    )
    String name;

    @Schema(
            description = "User username",
            example = "johnDoe"
    )
    @NotNull(
            message = "Username must be not null."
    )
    @Length(
            max = 255,
            message = "Username length must be smaller than 255 symbols."
    )
    String username;

    @Schema(
            description = "User encrypted password"
    )
    @JsonProperty(
            access = JsonProperty.Access.WRITE_ONLY
    )
    @NotNull(
            message = "Password must be not null."
    )
    String password;

}
