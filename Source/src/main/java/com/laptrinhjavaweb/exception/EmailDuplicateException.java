package com.laptrinhjavaweb.exception;

public class EmailDuplicateException extends Exception {
    public EmailDuplicateException(String errorMessage) {
        super(errorMessage);
    }
}
