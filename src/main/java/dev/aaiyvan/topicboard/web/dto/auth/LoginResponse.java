package dev.aaiyvan.topicboard.web.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private String access;
    private String refresh;

}
