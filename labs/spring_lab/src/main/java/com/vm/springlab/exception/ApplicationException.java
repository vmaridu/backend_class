package com.vm.springlab.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
    private String code;
    private String message;
}
