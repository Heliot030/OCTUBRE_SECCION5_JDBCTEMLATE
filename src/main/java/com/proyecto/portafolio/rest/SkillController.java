package com.proyecto.portafolio.rest;

import com.proyecto.portafolio.model.Skill;
import com.proyecto.portafolio.service.ISkillService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skill")
public class SkillController {
    private final ISkillService skillService;

    public SkillController(ISkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping()
    public List<Skill> getAllEducationInfo(){
        return skillService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Skill> finById(@PathVariable Long id){
        return skillService.findById(id);
    }

    @GetMapping("/personal-info/{id}")
    public List<Skill> findByPersonalInfoId(@PathVariable("id") Long personalInfo){
        return skillService.findByPersonalInfoId(personalInfo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Skill save(@RequestBody Skill skill  ){
        return skillService.save(skill);
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody Skill skill){
        skill.setId(id);
        return skillService.save(skill);
    }

}
