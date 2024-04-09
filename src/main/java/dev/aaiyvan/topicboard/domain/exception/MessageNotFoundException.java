package dev.aaiyvan.topicboard.domain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(
            final String message
    ) {
        super(message);
    }

}
