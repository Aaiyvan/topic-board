package dev.aaiyvan.topicboard.domain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidArgumentException extends IllegalArgumentException {

    public InvalidArgumentException(
            final String message
    ) {
        super(message);
    }

}
