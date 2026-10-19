package com.proyecto.portafolio.service;

import com.proyecto.portafolio.model.Skill;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ISkillService {
    Skill save(Skill skill );
    Optional<Skill> findById(Long id);
    List<Skill> findAll();
    void deleteById(Long id);
    List<Skill> findByPersonalInfoId(Long personalInfo);
}
