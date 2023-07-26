package com.vm.springlab.exception;

public class BadRequestException extends ApplicationException {
    public BadRequestException(String code, String message) {
        super(code, message);
    }
}
