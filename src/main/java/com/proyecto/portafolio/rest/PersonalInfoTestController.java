package com.proyecto.portafolio.rest;

import com.proyecto.portafolio.model.PersonalInfo;
import com.proyecto.portafolio.service.IPersonalInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/test-personal-info")
public class PersonalInfoTestController {

    private final IPersonalInfoService iPersonalInfoService;

    public PersonalInfoTestController(IPersonalInfoService iPersonalInfoService) {
        this.iPersonalInfoService = iPersonalInfoService;
    }

    @GetMapping("/all")
    public List<PersonalInfo> getAllPeronalInfo(){
         return iPersonalInfoService.findAll();
     }


    @GetMapping("/{id}")
    public PersonalInfo getAllPeronalInfoById(@PathVariable Long id){
        Optional<PersonalInfo> info =  iPersonalInfoService.findById(id);
        if (info.isPresent()){
            return info.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Informacion personal no disponible en el ID :  " + id);
        }
    }

    @PostMapping
    public ResponseEntity<PersonalInfo> createPersonalInfo(@RequestBody PersonalInfo personalInfo){
        PersonalInfo newPersonalInfo = iPersonalInfoService.save(personalInfo);
        return new ResponseEntity<>(newPersonalInfo, HttpStatus.CREATED);
    }
}
