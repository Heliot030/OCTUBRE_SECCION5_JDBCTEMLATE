package com.proyecto.portafolio.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    private Long id;
    @NotBlank(message ="La habilidad no debe ser vacio")
    private String name;
    @NotNull(message = "El porcentaje no pude ser nulo ")
    @Min(value = 0,message = "debe ser mayor a cero")
    @Max(value = 100, message = "dene ser menor a 100")
    private Integer levelPercentage;
    @NotBlank(message = "no puede estar en blanco")
    private String iconClass;
    private Long personalInfo;
}
