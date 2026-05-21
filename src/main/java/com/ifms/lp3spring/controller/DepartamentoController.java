package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ifms.lp3spring.Service.DepartamentoService;
import com.ifms.lp3spring.model.DepartamentoModel;

@Controller
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/salvardepartamento")
    public ModelAndView getSalvarDepartamento() {
        return new ModelAndView("departamento/salvardepartamento", "departamento", new DepartamentoModel());
    }

    @GetMapping("/listardepartamentos")
    public ModelAndView listarDepartamentos() {
        return new ModelAndView("departamento/listardepartamentos", "departamentos", departamentoService.buscarTodos());
    }
}