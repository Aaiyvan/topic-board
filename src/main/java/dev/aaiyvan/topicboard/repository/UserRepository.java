package dev.aaiyvan.topicboard.repository;

import dev.aaiyvan.topicboard.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID>, JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    @Query(value = """
             SELECT exists(
                           SELECT 1
                           FROM t_users_messages
                           WHERE user_id = :userId
                             AND message_id = :messageId)
            """, nativeQuery = true)
    boolean isMessageOwner(
            @Param("userId") UUID userId,
            @Param("messageId") UUID messageId
    );
}
