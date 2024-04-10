package dev.aaiyvan.topicboard.web.security.service;

import dev.aaiyvan.topicboard.web.security.SecurityUser;

import java.util.UUID;

public interface SecurityService {

    SecurityUser getUserFromRequest();

}
