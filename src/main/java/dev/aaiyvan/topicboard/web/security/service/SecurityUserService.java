package dev.aaiyvan.topicboard.web.security.service;

import dev.aaiyvan.topicboard.domain.model.user.User;
import dev.aaiyvan.topicboard.service.user.UserService;
import dev.aaiyvan.topicboard.web.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService {

    private final UserService userService;

    @Override
    public SecurityUser loadUserByUsername(
            final String username
    ) {
        User user = userService.getByUsername(username);
        return new SecurityUser(user);
    }

}
