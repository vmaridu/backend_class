package com.vm.springlab.exception;

public class ResourceNotFoundException extends ApplicationException{
    public ResourceNotFoundException(String code, String message) {
        super(code, message);
    }
}
