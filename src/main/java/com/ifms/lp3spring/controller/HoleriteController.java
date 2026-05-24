package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ifms.lp3spring.Service.HoleriteService;
import com.ifms.lp3spring.Service.FuncionarioService;
import com.ifms.lp3spring.model.HoleriteModel;
import com.ifms.lp3spring.model.FuncionarioModel;

import jakarta.validation.Valid;

@Controller
public class HoleriteController {

    @Autowired
    private HoleriteService holeriteService;

    @Autowired
    private FuncionarioService funcionarioService;

    // Listar todos
    @GetMapping("/manterholerite")
    public ModelAndView buscar() {
        return new ModelAndView("holerite/buscarholerite", "holerites", holeriteService.buscarTodos());
    }

    @GetMapping("/salvarholerite")
    public ModelAndView getSalvar() {
        ModelAndView mv = new ModelAndView("holerite/salvarholerite");
        mv.addObject("holerite", new HoleriteModel());
        mv.addObject("funcionarios", funcionarioService.buscarTodos());
        return mv;
    }

    // Salva o holerite
    /*@PostMapping("/salvarholerite")
    public ModelAndView salvar(@Valid @ModelAttribute("holerite") HoleriteModel holerite,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("holerite/salvarholerite");
        }
        holeriteService.inserir(holerite);
        return new ModelAndView("redirect:/manterholerite");
    }*/

    @PostMapping("/salvarholerite")
    public ModelAndView salvar(@Valid @ModelAttribute("holerite") HoleriteModel holerite,
            BindingResult result,
            @RequestParam("funcionario") Long funcionarioId) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("holerite/salvarholerite");
            mv.addObject("funcionarios", funcionarioService.buscarTodos());
            return mv;
        }

        // Busca o funcionário pelo id e seta no holerite
        FuncionarioModel funcionario = funcionarioService.buscarPorId(funcionarioId);
        holerite.setFuncionario(funcionario);

        holeriteService.inserir(holerite);
        return new ModelAndView("redirect:/manterholerite");
    }

    @GetMapping("/editarholerite/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        HoleriteModel holerite = holeriteService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("holerite/salvarholerite");
        mv.addObject("holerite", holerite);
        mv.addObject("funcionarios", funcionarioService.buscarTodos()); // importante
        return mv;
    }

    // Remover holerite
    @GetMapping("/removerholerite/{id}")
    public String remover(@PathVariable("id") Long id) {
        holeriteService.remover(id);
        return "redirect:/buscarholerite";
    }
}
