package dev.aaiyvan.topicboard.repository;

import dev.aaiyvan.topicboard.domain.model.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

    @Query(value = """
            SELECT * FROM t_messages m
            JOIN users_messages um ON um.message_id = m.id
            WHERE um.c_user_id = :userId
            """, nativeQuery = true)
    List<Message> findAllByUserId(
            @Param("userId") UUID userId
    );

}
