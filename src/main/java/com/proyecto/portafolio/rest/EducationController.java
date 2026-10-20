package com.proyecto.portafolio.rest;

import com.proyecto.portafolio.model.Education;
import com.proyecto.portafolio.model.PersonalInfo;
import com.proyecto.portafolio.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/education")
public class EducationController {
    private final IEducationService educationService;

    public EducationController(IEducationService educationService) {
        this.educationService = educationService;
    }


    @GetMapping()
    public List<Education> getAllEducationInfo(){
        return educationService.findAll();
    }

//    @GetMapping("/{id}")
//    public Education getAllEducationInfoById(@PathVariable Long id) {
//        Optional<Education> education = educationService.findById(id);
//        if (education.isPresent()){
//            return education.get();
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                    "informacion no encontrada id " + id);
//        }
//    }

    @GetMapping("/{id}")
    public Optional<Education> finById(@PathVariable Long id){
        return educationService.findById(id);
    }

//    @PostMapping
//    public ResponseEntity<Education> createEducationInfo(@RequestBody Education education){
//        Education educationnew = educationService.save(education);
//        return new ResponseEntity<>(educationnew, HttpStatus.CREATED);
//    }

    @PostMapping
   // @ResponseStatus(HttpStatus.CREATED)
    public Education save(@RequestBody Education education){
        return educationService.save(education);
    }

    @PutMapping("/{id}")
    public Education update(@PathVariable Long id, @RequestBody Education education){
        education.setId(id); //
        return educationService.save(education);
    }

    @DeleteMapping("/{id}")
    public void deleteBy(@PathVariable Long id){
        educationService.deleteById(id);
    }

}
