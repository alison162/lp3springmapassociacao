package com.ifms.framespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifms.framespring.Service.AlunoService;
import com.ifms.framespring.Service.CursoService;
import com.ifms.framespring.model.CursoModel;

import jakarta.validation.Valid;

@Controller
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/salvarcurso")
    public String getSalvar(Model model) {
        model.addAttribute("curso", new CursoModel());
        model.addAttribute("alunos", alunoService.buscarTodos());
        return "curso/salvarcurso";
    }

    @PostMapping("/salvarcurso")
    public String postSalvar(@Valid @ModelAttribute("curso") CursoModel curso,
            BindingResult result) {
        if (result.hasErrors()) {
            return "curso/salvarcurso";
        }

        cursoService.inserir(curso);
        return "redirect:/mantercurso";
    }

    @GetMapping("/mantercurso")
    public ModelAndView buscar() {
        return new ModelAndView("curso/buscarcurso", "cursos", cursoService.buscarTodos());
    }

    @GetMapping("/editarcurso/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        CursoModel curso = cursoService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("curso/salvarcurso");
        mv.addObject("curso", curso);

        mv.addObject("alunos", alunoService.buscarTodos());
        return mv;
    }

    @GetMapping("/removercurso/{id}")
    public String remover(@PathVariable Long id,
            RedirectAttributes redirectAttributes) {

        String retorno = cursoService.remover(id);

        if (retorno.contains("sucesso")) {
            redirectAttributes.addFlashAttribute("sucesso", retorno);
        } else {
            redirectAttributes.addFlashAttribute("erro", retorno);
        }

        return "redirect:/mantercurso";
    }

    public CursoService getCursoService() {
        return cursoService;
    }

    public void setCursoService(CursoService cursoService) {
        this.cursoService = cursoService;
    }
}