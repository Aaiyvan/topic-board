package dev.aaiyvan.topicboard.web.security.expression;

import dev.aaiyvan.topicboard.domain.model.user.Role;
import dev.aaiyvan.topicboard.service.user.UserService;
import dev.aaiyvan.topicboard.web.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("cse")
@RequiredArgsConstructor
public class CustomSecurityExpression {

    private final UserService userService;

    public boolean canAccessUser(
            final UUID id
    ) {
        SecurityUser user = getPrincipal();
        UUID userId = user.getId();

        return userId.equals(id) || hasAnyRole(Role.ROLE_ADMIN);
    }

    private boolean hasAnyRole(
            final Role... roles
    ) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        for (Role role : roles) {
            SimpleGrantedAuthority authority
                    = new SimpleGrantedAuthority(role.name());
            if (authentication.getAuthorities().contains(authority)) {
                return true;
            }
        }
        return false;
    }

    public boolean canAccessMessage(
            final UUID messageId
    ) {
        SecurityUser user = getPrincipal();
        UUID userId = user.getId();

        return userService.isMessageOwner(userId, messageId) || hasAnyRole(Role.ROLE_ADMIN);
    }

    private SecurityUser getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        return (SecurityUser) authentication.getPrincipal();
    }

}
