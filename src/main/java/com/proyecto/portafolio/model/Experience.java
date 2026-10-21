package com.proyecto.portafolio.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
    private Long id;
    @NotBlank(message = "el titulo del trabajo no puede estar vacio")
    private String jobTitle;

    @NotBlank(message = "el nombre de la compañia no puede estar vacio")
    private String coompanyName;

    @NotNull(message = "El fecha no pude ser nulo ")
    @PastOrPresent(message = "la fecha de incio no puede ser futura")
    private LocalDateTime starDate;

    @PastOrPresent(message = "la fecha de termino no puede ser futura")
    private LocalDateTime endData;

    @NotBlank(message ="La habilidad no debe ser vacio")
    private String description;
    private Long personalInfoId;
}
