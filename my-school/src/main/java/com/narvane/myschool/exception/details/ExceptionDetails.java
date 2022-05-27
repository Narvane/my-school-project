package com.narvane.myschool.exception.details;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class ExceptionDetails {

    protected String title;

    protected int status;

    protected String detail;

    protected LocalDateTime timestamp;

    protected String developerMessage;

}