package com.ifms.framespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ifms.framespring.Service.AlunoService;
import com.ifms.framespring.model.AlunoModel;
import org.springframework.dao.DataIntegrityViolationException;
import jakarta.validation.Valid;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/salvaraluno")
    public ModelAndView getSalvar() {
        ModelAndView mv = new ModelAndView("aluno/salvaraluno");
        mv.addObject("aluno", new AlunoModel());
        return mv;
    }

    @PostMapping("/salvaraluno")
    public String postSalvar(@Valid @ModelAttribute("aluno") AlunoModel aluno,
            BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("temErro", true);
            model.addAttribute("erros", result.getAllErrors());

            return "aluno/salvaraluno";
        }

        alunoService.inserir(aluno);

        return "redirect:/manteraluno";
    }

    @GetMapping("/manteraluno")
    public ModelAndView buscar() {
        return new ModelAndView("aluno/buscaraluno", "alunos", alunoService.buscarTodosOrdenadosPorNome());
    }

    @GetMapping("/editaraluno/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        AlunoModel aluno = alunoService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("aluno/salvaraluno");
        mv.addObject("aluno", aluno);
        return mv;
    }

    @GetMapping("/removeraluno/{id}")
    public String remover(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

        try {

            alunoService.remover(id);

            redirectAttributes.addFlashAttribute(
                    "sucesso",
                    "Aluno removido com sucesso!");

        } catch (DataIntegrityViolationException e) {

            redirectAttributes.addFlashAttribute(
                    "erro",
                    "Não é possível excluir este aluno pois ele está vinculado a um relacionamento.");

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute(
                    "erro",
                    "Erro ao remover aluno.");
        }

        return "redirect:/manteraluno";
    }

    public AlunoService getAlunoService() {
        return alunoService;
    }

    public void setAlunoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

}