package ru.t1consulting.t1_test_task.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@Slf4j
public class TestTaskExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleBadParametersExceptionHandler(MissingServletRequestParameterException exception) {
        log.info(exception.getMessage());
        return Map.of("error", "Bad request",
                "errorMessage", exception.getMessage());
    }
}
