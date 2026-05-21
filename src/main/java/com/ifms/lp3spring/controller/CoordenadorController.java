package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ifms.lp3spring.Service.CoordenadorService;
import com.ifms.lp3spring.Service.DepartamentoService;
import com.ifms.lp3spring.model.CoordenadorModel;

import jakarta.validation.Valid;

@Controller
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    @Autowired
    private DepartamentoService departamentoService;

    // GET para abrir o formulário
    @GetMapping("/salvarcoordenador")
    public ModelAndView getSalvar() {
        return new ModelAndView("coordenador/salvarcoordenador", "coordenador", new CoordenadorModel());
    }

    // POST para salvar
    @PostMapping("/salvarcoordenador")
    public ModelAndView postSalvar(@Valid @ModelAttribute("coordenador") CoordenadorModel coordenador,
                                   BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("coordenador/salvarcoordenador");
            mv.addObject("departamentos", departamentoService.buscarTodos());
            return mv;
        }
        coordenadorService.inserir(coordenador);
        return new ModelAndView("redirect:/mantercoordenador");
    }

    // Listar todos
    @GetMapping("/mantercoordenador")
    public ModelAndView buscar() {
        return new ModelAndView("coordenador/buscarcoordenador", "coordenadores", coordenadorService.buscarTodos());
    }

    // Remover por ID
    @GetMapping("/removercoordenador/{id}")
    public String deletar(@PathVariable("id") Long id) {
        coordenadorService.remover(id);
        return "redirect:/mantercoordenador";
    }

    // Buscar por ID para edição
    @GetMapping("/salvarcoordenador/{id}")
    public ModelAndView buscarPorId(@PathVariable("id") Long id) {
        CoordenadorModel coordenador = coordenadorService.buscarPorId(id);
        if (coordenador == null) {
            coordenador = new CoordenadorModel();
        }
        ModelAndView mv = new ModelAndView("coordenador/salvarcoordenador");
        mv.addObject("coordenador", coordenador);
        mv.addObject("departamentos", departamentoService.buscarTodos());
        return mv;
    }
}