package com.proyecto.portafolio.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfo {
    private Long id;

    @NotBlank(message = "El nombre no debe ser vacio")
    private String firstName;
    @NotBlank(message = "El apellido no debe ser vacio")
    private String lastName;
    @NotBlank(message = "El titulo no debe ser vacio")
    private String title;
    @NotBlank(message = "la decripcion  no debe ser vacio")
    private String profileDescription;
    @NotBlank(message = "la imagen no debe de estar vacio")
    private String profileImageUrl;
    @Min(value = 0, message = "los años no deben de ser menor a 0 ")
    private Integer yearsOdExperrience;
    @Email(message = "no es valido")
    private String email;
    @NotBlank(message = "el telfono no debe ser vacio")
    private String phone;
    @NotBlank(message = "el linkerdinUrl no debe ser vacio")
    private String linkerdinUrl;
    @NotBlank(message = "el githubUrl no debe ser vacio")
    private String githubUrl;

}
