package com.blogging.platform.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogPostException.class)
    public ResponseEntity<ErrorResponse> handleBlogPostExceptions(BlogPostException exception, WebRequest request) {
        HttpStatus status = HttpStatus.OK; // set the default status
        Causes cause = exception.cause;

        switch (cause) {
            case NO_EMPTY_FIELDS_ALLOWED -> status = HttpStatus.BAD_REQUEST;
            case BLOG_ID_DOES_NOT_EXIST -> status = HttpStatus.NOT_FOUND;
        }

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                exception.getMessage(),
                exception.getCause().getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

}
