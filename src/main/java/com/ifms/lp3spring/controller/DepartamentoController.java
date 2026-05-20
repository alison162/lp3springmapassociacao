package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifms.lp3spring.Repository.DepartamentoRepository;

@Controller
public class DepartamentoController {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping("salvardepartamento")
    public String getSalvar() {
        return "departamento/salvardepartamento";
    }


    public DepartamentoRepository getDepartamentoRepository(){
        return departamentoRepository;
    }

    public void setDepartamentoRepository(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }
}