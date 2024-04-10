package dev.aaiyvan.topicboard.web.security.service;

import dev.aaiyvan.topicboard.service.user.UserService;
import dev.aaiyvan.topicboard.web.security.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("ssi")
public class SecurityServiceImpl implements SecurityService {

    @Override
    public SecurityUser getUserFromRequest() {

        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return (SecurityUser) authentication
                .getPrincipal();
    }

}
