package com.proyecto.portafolio.service;

import com.proyecto.portafolio.model.PersonalInfo;

import java.util.List;
import java.util.Optional;

public interface IPersonalInfoService {
    PersonalInfo save(PersonalInfo personalInfo);
    Optional<PersonalInfo> findById(Long id);
    List<PersonalInfo> findAll();
    void deleteById(Long id);
}

