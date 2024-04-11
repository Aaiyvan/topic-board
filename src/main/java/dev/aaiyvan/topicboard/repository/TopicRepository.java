package dev.aaiyvan.topicboard.repository;

import dev.aaiyvan.topicboard.domain.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TopicRepository extends PagingAndSortingRepository<Topic, UUID>, JpaRepository<Topic, UUID> {

}
