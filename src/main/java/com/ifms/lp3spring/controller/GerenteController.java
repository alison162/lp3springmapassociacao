package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifms.lp3spring.Service.GerenteService;
import com.ifms.lp3spring.model.GerenteModel;

import jakarta.validation.Valid;


@Controller
public class GerenteController {
    @Autowired
    private GerenteService gerenteService;

    @GetMapping("/salvargerente")
    public ModelAndView getSalvar() {
        return new ModelAndView("gerente/salvargerente", "gerente", new GerenteModel());
    }
    
    @PostMapping("/salvargerente")
    public String postSalvar(@Valid @ModelAttribute("gerente") GerenteModel gerente, BindingResult result) {
        if (result.hasErrors()) {
            return "gerente/salvargerente";
        }
        
        gerenteService.inserir(gerente);
        return "redirect:/mantergerente";
    }  

    @GetMapping("/mantergerente")
    public ModelAndView buscar() {
        return new ModelAndView("gerente/buscargerente", "gerentes", gerenteService.buscarTodos());
    }

    @GetMapping("/removergerente/{id}")
    public String deletar(@ModelAttribute("id") Long id) {
        gerenteService.remover(id);
        return "redirect:/mantergerente";
    }

    @GetMapping("/salvargerente/{id}")
    public ModelAndView buscarPorId(@ModelAttribute("id") Long id) {
        GerenteModel gerente = gerenteService.buscarPorId(id);
        if (gerente==null) {
            gerente = new GerenteModel();
        }
        return new ModelAndView("/gerente/salvargerente", "gerente", new GerenteModel());
    }

    public GerenteService getGerenteService() {
        return gerenteService;
    }

    public void setGerenteService(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }
}