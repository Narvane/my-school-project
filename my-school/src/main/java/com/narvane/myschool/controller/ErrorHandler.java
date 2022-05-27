package com.narvane.myschool.controller;

import static com.narvane.myschool.constants.ErrorMessagesConstants.*;
import com.narvane.myschool.exception.AccessDeniedException;
import com.narvane.myschool.exception.ResourceNotFoundException;
import com.narvane.myschool.exception.details.ExceptionDetails;
import com.narvane.myschool.exception.details.ResourceNotFoundDetails;
import com.narvane.myschool.exception.details.ValidationExceptionDetails;
import com.sun.istack.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    private static final String DELIMITER = ", ";

    @ExceptionHandler(ResourceNotFoundException .class)
    public ResponseEntity<ResourceNotFoundDetails> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ResponseEntity<>(
                ResourceNotFoundDetails.builder()
                        .timestamp(now())
                        .status(NOT_FOUND.value())
                        .title(RESOURCE_NOT_FOUND_ERROR_TITLE)
                        .detail(exception.getMessage())
                        .developerMessage(exception.getClass().getSimpleName())
                        .build(), NOT_FOUND
        );
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ResourceNotFoundDetails> handleAccessDeniedException(AccessDeniedException exception) {

        return new ResponseEntity<>(
                ResourceNotFoundDetails.builder()
                        .timestamp(now())
                        .status(FORBIDDEN.value())
                        .title(ACCESS_DENIED_ERROR_TITLE)
                        .detail(exception.getMessage())
                        .developerMessage(exception.getClass().getSimpleName())
                        .build(), FORBIDDEN
        );
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionDetails> handleUnauthorizedException(BadCredentialsException exception) {

        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .timestamp(now())
                        .status(UNAUTHORIZED.value())
                        .title(UNAUTHORIZED_ERROR_TITLE)
                        .detail(exception.getMessage())
                        .developerMessage(exception.getClass().getSimpleName())
                        .build(), UNAUTHORIZED
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(DELIMITER));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(DELIMITER));

        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .timestamp(now())
                        .title(FIELD_VALIDATION_ERROR_TITLE)
                        .detail(FIELD_VALIDATION_ERROR_DETAIL)
                        .developerMessage(exception.getClass().getName())
                        .fields(fields)
                        .fieldsMessage(fieldsMessage)
                        .build(), BAD_REQUEST
        );

    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .timestamp(now())
                .status(status.value())
                .title(ex.getCause().getMessage())
                .detail(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails, headers, status);
    }

}