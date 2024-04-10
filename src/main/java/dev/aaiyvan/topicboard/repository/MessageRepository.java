package dev.aaiyvan.topicboard.repository;

import dev.aaiyvan.topicboard.domain.model.message.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends PagingAndSortingRepository<Message, UUID>, JpaRepository<Message, UUID> {

    @Query(value = """
            SELECT * FROM t_messages m
            JOIN t_users_messages um ON um.message_id = m.id
            WHERE um.user_id = :userId
            """, nativeQuery = true)
    Page<Message> findAllByUserId(
            @Param("userId") UUID userId,
            Pageable pageable
    );

    @Query(value = """
            SELECT * FROM t_messages m
            JOIN t_topics_messages tm ON tm.message_id = m.id
            WHERE tm.topic_id = :topicId
            """, nativeQuery = true)
    Page<Message> findAllMessagesByTopicId(
            @Param("topicId") UUID topicId,
            Pageable pageable
    );

}
