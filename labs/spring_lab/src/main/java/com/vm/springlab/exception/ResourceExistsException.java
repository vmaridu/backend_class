package com.vm.springlab.exception;

public class ResourceExistsException extends ApplicationException{
    public ResourceExistsException(String code, String message) {
        super(code, message);
    }
}
