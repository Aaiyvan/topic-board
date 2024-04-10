package dev.aaiyvan.topicboard.web.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    @NotNull
    String name;

    @NotNull
    String username;

    @NotNull
    String password;

}
