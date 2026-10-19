package com.proyecto.portafolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String personalInfoId;
}
