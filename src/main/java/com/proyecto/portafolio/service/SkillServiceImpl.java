package com.proyecto.portafolio.service;

import com.proyecto.portafolio.exception.ValidationException;
import com.proyecto.portafolio.model.Skill;
import com.proyecto.portafolio.repository.ISkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements ISkillService{

    private final ISkillRepository skillRepository;
    private final Validator validator;

    public SkillServiceImpl(ISkillRepository skillRepository, Validator validator) {
        this.skillRepository = skillRepository;
        this.validator = validator;
    }

    @Override
    @Transactional
    public Skill save(Skill skill) {
        BindingResult result = new BeanPropertyBindingResult(skill,"skill");
        validator.validate(skill,result);
        if (result.hasErrors()){
            throw new ValidationException(result);
        }
        return skillRepository.save(skill);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Skill> findByPersonalInfoId(Long personalInfo) {
        return skillRepository.findByPersonalInfoId(personalInfo);
    }
}
