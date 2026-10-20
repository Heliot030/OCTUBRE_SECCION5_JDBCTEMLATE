package com.proyecto.portafolio.exception.handler;

import com.proyecto.portafolio.exception.ValidationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public String handleValidationException(ValidationException ex, Model model){
        model.addAttribute("errors", ex.getBindingResult().getAllErrors());
        model.addAttribute("message","se encontraron  erores en la validacion");
        return "validation";
    }
}
