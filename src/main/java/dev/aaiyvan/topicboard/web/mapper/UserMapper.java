package dev.aaiyvan.topicboard.web.mapper;

import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.web.dto.user.UserRequest;
import dev.aaiyvan.topicboard.web.dto.user.UserResponse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mappings({
//            @Mapping(target = "id", ignore = true),
//    })
    User toUser(UserResponse userResponse);

//    @Mappings({
//            @Mapping(target = "id", ignore = true),
//            @Mapping(target = "roles", ignore = true),
//            @Mapping(target = "messages", ignore = true)
//    })
    User toUser(UserRequest userRequest);

//    @InheritInverseConfiguration(name = "toUser")
    UserResponse toResponse(User user);

    UserRequest toRequest(User user);

    List<UserResponse> toResponse(List<User> users);

}
