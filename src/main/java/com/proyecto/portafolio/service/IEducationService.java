package com.proyecto.portafolio.service;

import com.proyecto.portafolio.model.Education;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IEducationService {
    List<Education> findAll();
    Optional<Education> findById(Long id);
    Education save(Education education);
    void deleteById(Long id);
    List<Education> findEducationByPersonalInfoId(Long personalInfoId);
}
