package dev.aaiyvan.topicboard.web.controller.advice;

import dev.aaiyvan.topicboard.domain.exception.InvalidArgumentException;
import dev.aaiyvan.topicboard.domain.exception.MessageNotFoundException;
import dev.aaiyvan.topicboard.domain.exception.TopicNotFoundException;
import dev.aaiyvan.topicboard.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    ProblemDetail handlerUserNotFoundException(
            final UserNotFoundException exception
    ) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(MessageNotFoundException.class)
    ProblemDetail handlerMessageNotFoundException(
            final MessageNotFoundException exception
    ) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(TopicNotFoundException.class)
    ProblemDetail handlerTopicNotFoundException(
            final TopicNotFoundException exception
    ) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(InvalidArgumentException.class)
    ProblemDetail handlerInvalidArgumentException(
            final InvalidArgumentException exception
    ) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
