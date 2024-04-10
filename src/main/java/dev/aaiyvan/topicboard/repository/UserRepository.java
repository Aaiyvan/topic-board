package dev.aaiyvan.topicboard.repository;

import dev.aaiyvan.topicboard.domain.model.message.Message;
import dev.aaiyvan.topicboard.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);

    boolean existsByUsername(String username);
}
