package dev.aaiyvan.topicboard.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Response after login")
public class LoginResponse {

    private String access;
    private String refresh;

}
