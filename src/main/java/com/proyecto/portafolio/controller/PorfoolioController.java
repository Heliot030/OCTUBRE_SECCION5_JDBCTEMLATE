package com.proyecto.portafolio.controller;

import com.proyecto.portafolio.model.PersonalInfo;
import com.proyecto.portafolio.service.IPersonalInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PorfoolioController {
    private final IPersonalInfoService personalInfoService;

    public PorfoolioController(IPersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("personalInfo", new PersonalInfo());
        return "form";
    }

    @PostMapping("/personal-info-save")
    public String savePersonalInfo(@ModelAttribute("personalInfo") PersonalInfo personalInfo){
        personalInfoService.save(personalInfo);
        return "redirect:/";
    }
}
