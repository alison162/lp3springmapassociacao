package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifms.lp3spring.Service.CoordenadorService;
import com.ifms.lp3spring.model.CoordenadorModel;

import jakarta.validation.Valid;

@Controller
public class CoordenadorController {
    
 @Autowired
    private CoordenadorService coordenadorService;

    @GetMapping("/salvarcoordenador")
    public ModelAndView getSalvar() {
        return new ModelAndView("coordenador/salvarcoordenador", "coordenador", new CoordenadorModel());
    }
    
    @PostMapping("/salvarcoordenador")
    public String postSalvar(@Valid @ModelAttribute("coordenador") CoordenadorModel coordenador, BindingResult result) {
        if (result.hasErrors()) {
            return "coordenador/salvarcoordenador";
        }
        
        coordenadorService.inserir(coordenador);
        return "redirect:/salvarcoordenador";
    }  

    public CoordenadorService getCoordenadorService() {
        return coordenadorService;
    }

    public void setCoordenadorService(CoordenadorService coordenadorService) {
        this.coordenadorService = coordenadorService;
    }
}
