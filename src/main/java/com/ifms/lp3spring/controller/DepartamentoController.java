package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifms.lp3spring.Service.DepartamentoService;
import com.ifms.lp3spring.model.DepartamentoModel;

import jakarta.validation.Valid;

@Controller
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/salvardepartamento")
    public String getSalvar(Model model) {
        model.addAttribute("departamento", new DepartamentoModel());
        return "departamento/salvardepartamento";
    }

    @PostMapping("/salvardepartamento")
    public String postSalvar(@Valid @ModelAttribute("departamento") DepartamentoModel departamento,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "departamento/salvardepartamento";
        }

        departamentoService.inserir(departamento);
        // igual ao DisciplinaController, redireciona para o próprio formulário
        return "redirect:/salvardepartamento";
    }


    
      // Listar todos
    @GetMapping("/manterdepartamento")
    public ModelAndView buscar() {
        return new ModelAndView("departamento/buscardepartamento", "departamentos", departamentoService.buscarTodos());
    }


    public DepartamentoService getDepartamentoService() {
        return departamentoService;
    }

    public void setDepartamentoService(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }
}