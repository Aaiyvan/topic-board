package dev.aaiyvan.topicboard.repository;

import dev.aaiyvan.topicboard.domain.model.message.Message;
import dev.aaiyvan.topicboard.domain.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {

}
