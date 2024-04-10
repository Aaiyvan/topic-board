package dev.aaiyvan.topicboard.repository;

import dev.aaiyvan.topicboard.domain.model.message.Message;
import dev.aaiyvan.topicboard.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID>, JpaRepository<User, UUID> {

    User findByUsername(String username);

    boolean existsByUsername(String username);
}
