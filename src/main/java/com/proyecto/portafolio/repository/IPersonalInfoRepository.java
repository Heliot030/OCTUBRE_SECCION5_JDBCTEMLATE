package com.proyecto.portafolio.repository;

import com.proyecto.portafolio.model.PersonalInfo;

import java.util.List;
import java.util.Optional;

public interface IPersonalInfoRepository {
    PersonalInfo save(PersonalInfo personalInfo);
    Optional<PersonalInfo> findById(Long id);
    List<PersonalInfo> findAll();
    void deleteById(Long id);
}
