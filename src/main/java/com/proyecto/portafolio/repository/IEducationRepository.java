package com.proyecto.portafolio.repository;

import com.proyecto.portafolio.model.Education;

import java.util.List;
import java.util.Optional;

public interface IEducationRepository {
    Education save(Education education);
    Optional<Education> findById(Long id);
    List<Education> findAll();
    void deleteById(Long id);
    List<Education> findByPersonalInfoId(Long personalInfoId);
}
