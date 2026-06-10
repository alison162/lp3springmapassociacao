package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/salvarholerite")
    public ModelAndView salvar(@Valid @ModelAttribute("holerite") HoleriteModel holerite,
            BindingResult result,
            @RequestParam("funcionario") Long funcionarioId) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("holerite/salvarholerite");
            mv.addObject("funcionarios", funcionarioService.buscarTodos());
            return mv;
        }

    
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
        mv.addObject("funcionarios", funcionarioService.buscarTodos()); 
        return mv;
    }

@GetMapping("/removerholerite/{id}")
public String remover(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

    try {

        holeriteService.remover(id);

        redirectAttributes.addFlashAttribute(
                "sucesso",
                "Holerite removido com sucesso!"
        );

    } catch (DataIntegrityViolationException e) {

        redirectAttributes.addFlashAttribute(
                "erro",
                "Não é possível excluir este holerite pois ele está vinculado a um relacionamento."
        );

    } catch (Exception e) {

        redirectAttributes.addFlashAttribute(
                "erro",
                "Erro ao remover holerite."
        );
    }

    return "redirect:/manterholerite";
}

}
