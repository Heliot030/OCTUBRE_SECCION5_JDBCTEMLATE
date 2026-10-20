package com.proyecto.portafolio.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
public class ValidationException extends RuntimeException {

    private final BindingResult bindingResult;

    public ValidationException(BindingResult bindingResult) {
        super("Error de validaciones : se encontyraron "+ bindingResult.getErrorCount());
        this.bindingResult = bindingResult;
    }
}
