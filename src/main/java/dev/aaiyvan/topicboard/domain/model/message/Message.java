package dev.aaiyvan.topicboard.domain.model.message;

import dev.aaiyvan.topicboard.domain.model.topic.Topic;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_messages")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message implements Serializable {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.VARCHAR)
    UUID id;

    @Column(name = "c_author_name")
    String authorName;

    @Column(name = "c_text")
    String text;

    @CreationTimestamp
    @Column(name = "c_creation_date")
    LocalDateTime creationDate;

}
