package com.proyecto.portafolio.rest;

import com.proyecto.portafolio.model.Education;
import com.proyecto.portafolio.model.Experience;
import com.proyecto.portafolio.service.IExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    private final IExperienceService experienceService;

    public ExperienceController(IExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping()
    public List<Experience> getAllEducationInfo(){
        return experienceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> finById(@PathVariable Long id){
        Optional<Experience> experience= experienceService.findById(id);
        if (experience.isPresent()){
            return new ResponseEntity<>(experience.get(), HttpStatus.OK);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Informacion del ID no encontrada  " + id);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Experience save(@RequestBody Experience experience ){
        return experienceService.save(experience);
    }


    @PutMapping("/{id}")
    public Experience update(@PathVariable Long id, @RequestBody Experience experience){
        experience.setId(id); //
        return experienceService.save(experience);
    }

    @DeleteMapping("/{id}")
    public void deleteBy(@PathVariable Long id){
        experienceService.deleteById(id);
    }

}
