package com.proyecto.portafolio.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    private Long id;
    @NotBlank(message ="No puede ser vacio el titulo  educativo")
    private String degree;
    @NotBlank(message ="El nombre de la instotucion no debe estar vacio")
    private String institution;

    @NotNull(message = "El fecha no pude ser nulo ")
    @PastOrPresent(message = "la fecha de incio no puede ser futura")
    private LocalDateTime starDate;

    @PastOrPresent(message = "la fecha de termino no puede ser futura")
    private LocalDateTime endData; // puede ser nula

    @NotBlank(message ="La habilidad no debe ser vacio")
    private String description;
    private Long personalInfo;
}
