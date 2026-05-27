package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifms.lp3spring.Service.CoordenadorService;
import com.ifms.lp3spring.Service.DepartamentoService;
import com.ifms.lp3spring.Service.GerenteService;
import com.ifms.lp3spring.model.DepartamentoModel;

import jakarta.validation.Valid;

@Controller
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private GerenteService gerenteService;

    @Autowired
    private CoordenadorService coordenadorService;

    @GetMapping("/salvardepartamento")
    public String getSalvar(Model model) {
        model.addAttribute("departamento", new DepartamentoModel());
        model.addAttribute("gerentes", gerenteService.buscarTodos());
        model.addAttribute("coordenadores", coordenadorService.buscarTodos());
        return "departamento/salvardepartamento";

    }

    @PostMapping("/salvardepartamento")
    public String postSalvar(@Valid @ModelAttribute("departamento") DepartamentoModel departamento,
            BindingResult result) {
        if (result.hasErrors()) {
            return "departamento/salvardepartamento";
        }

        departamentoService.inserir(departamento);
        return "redirect:/salvardepartamento";
    }

    @GetMapping("/manterdepartamento")
    public ModelAndView buscar() {
        return new ModelAndView("departamento/buscardepartamento", "departamentos", departamentoService.buscarTodos());
    }

    @GetMapping("/editardepartamento/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        DepartamentoModel departamento = departamentoService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("departamento/salvardepartamento");
        mv.addObject("departamento", departamento);

        mv.addObject("gerentes", gerenteService.buscarTodos());

        mv.addObject("coordenadores", coordenadorService.buscarTodos());
        return mv;
    }

    @GetMapping("/removerdepartamento/{id}")
    public String remover(@PathVariable("id") Long id) {
        departamentoService.remover(id);
        return "redirect:/manterdepartamento";
    }

    public DepartamentoService getDepartamentoService() {
        return departamentoService;
    }

    public void setDepartamentoService(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }
}