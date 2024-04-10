package dev.aaiyvan.topicboard.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotNull(
            message = "Username must be not null."
    )
    private String username;

    @NotNull(
            message = "Password must be not null."
    )
    private String password;

}
