package dev.aaiyvan.topicboard.domain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TopicNotFoundException extends RuntimeException {

    public TopicNotFoundException(
            final String message
    ) {
        super(message);
    }

}
