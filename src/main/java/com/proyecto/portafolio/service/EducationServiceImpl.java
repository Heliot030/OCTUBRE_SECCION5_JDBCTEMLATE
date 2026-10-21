package com.proyecto.portafolio.service;

import com.proyecto.portafolio.exception.ValidationException;
import com.proyecto.portafolio.model.Education;
import com.proyecto.portafolio.repository.IEducationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements IEducationService{

    private final IEducationRepository educationRepository;
    private final Validator validator;

    public EducationServiceImpl(IEducationRepository educationRepository, Validator validator) {
        this.educationRepository = educationRepository;
        this.validator = validator;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Education> findById(Long id) {
        return educationRepository.findById(id);
    }

    @Override
    @Transactional
    public Education save(Education education) {
        BindingResult result = new BeanPropertyBindingResult(education,"skill");
        validator.validate(education,result);
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        return educationRepository.save(education);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        System.out.println("Eliminando educación por ID: " + id + " en el servicio...");
        educationRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Education> findEducationByPersonalInfoId(Long personalInfoId) {
        return educationRepository.findByPersonalInfoId(personalInfoId);
    }

}
