package com.proyecto.portafolio.service;

import com.proyecto.portafolio.exception.ValidationException;
import com.proyecto.portafolio.model.PersonalInfo;
import com.proyecto.portafolio.repository.IPersonalInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;


import java.util.List;
import java.util.Optional;

@Service
public class PeronalInfoServiceImpl implements IPersonalInfoService{


    private final IPersonalInfoRepository iPersonalInfoRepository;
    private final Validator validator;

    public PeronalInfoServiceImpl(IPersonalInfoRepository iPersonalInfoRepository, Validator validator) {
        this.iPersonalInfoRepository = iPersonalInfoRepository;
        this.validator = validator;
    }

    @Override
    @Transactional
    public PersonalInfo save(PersonalInfo personalInfo) {
         BindingResult result = new BeanPropertyBindingResult(personalInfo,"personalInfo");
         validator.validate(personalInfo,result);
        if (result.hasErrors()){
            throw new ValidationException(result);
        }
        return iPersonalInfoRepository.save(personalInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PersonalInfo> findById(Long id) {
        return iPersonalInfoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalInfo> findAll() {
        return iPersonalInfoRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        iPersonalInfoRepository.deleteById(id);
    }
}
