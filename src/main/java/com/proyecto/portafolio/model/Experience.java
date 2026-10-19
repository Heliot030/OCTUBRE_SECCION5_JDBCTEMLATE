package com.proyecto.portafolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
    private Long id;
    private String jobTitle;
    private String coompanyName;
    private LocalDateTime starDate;
    private LocalDateTime endData;
    private String description;
    private Long personalInfoId;
}
