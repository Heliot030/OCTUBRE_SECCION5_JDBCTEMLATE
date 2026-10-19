package com.proyecto.portafolio.service;

import com.proyecto.portafolio.model.PersonalInfo;
import com.proyecto.portafolio.repository.IPersonalInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeronalInfoServiceImpl implements IPersonalInfoService{


    private final IPersonalInfoRepository iPersonalInfoRepository;

    public PeronalInfoServiceImpl(IPersonalInfoRepository iPersonalInfoRepository) {
        this.iPersonalInfoRepository = iPersonalInfoRepository;
    }

    @Override
    public PersonalInfo save(PersonalInfo personalInfo) {
        return iPersonalInfoRepository.save(personalInfo);
    }

    @Override
    public Optional<PersonalInfo> findById(Long id) {
        return iPersonalInfoRepository.findById(id);
    }

    @Override
    public List<PersonalInfo> findAll() {
        return iPersonalInfoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        iPersonalInfoRepository.deleteById(id);
    }
}
