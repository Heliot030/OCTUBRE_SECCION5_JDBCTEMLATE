package com.proyecto.portafolio.service;

import com.proyecto.portafolio.model.Skill;
import com.proyecto.portafolio.repository.ISkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements ISkillService{

    private final ISkillRepository skillRepository;

    public SkillServiceImpl(ISkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill save(Skill skill) {
        if (skill.getLevelPercentage() < 0 || skill.getLevelPercentage() > 100){
            throw new IllegalArgumentException("el porcentaje debe  de etsa entre 0 y 100");
        }
        return skillRepository.save(skill);
    }

    @Override
    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public List<Skill> findByPersonalInfoId(Long personalInfo) {
        return skillRepository.findByPersonalInfoId(personalInfo);
    }
}
