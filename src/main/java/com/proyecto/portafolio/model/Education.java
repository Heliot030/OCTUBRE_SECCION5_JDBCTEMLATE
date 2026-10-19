package com.proyecto.portafolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    private Long id;
    private String degree;
    private String institution;
    private LocalDateTime starDate;
    private LocalDateTime endData;
    private String description;
    private Long personalInfo;
}
