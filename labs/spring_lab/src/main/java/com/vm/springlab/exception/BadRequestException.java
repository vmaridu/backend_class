package com.vm.springlab.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;


public class BadRequestException extends ApplicationException {
    public BadRequestException(String code, String message) {
        super(code, message);
    }
}
