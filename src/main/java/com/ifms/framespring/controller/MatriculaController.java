package com.ifms.framespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifms.framespring.Service.AlunoService;
import com.ifms.framespring.Service.CursoService;
import com.ifms.framespring.Service.MatriculaService;
import com.ifms.framespring.model.AlunoModel;
import com.ifms.framespring.model.CursoModel;
import com.ifms.framespring.model.MatriculaModel;

import jakarta.validation.Valid;

@Controller
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    @GetMapping("/mantermatricula")
    public ModelAndView buscar() {
        return new ModelAndView("matricula/buscarmatricula", "matriculas", matriculaService.buscarTodos());
    }

    @GetMapping("/salvarmatricula")
    public ModelAndView getSalvar() {
        ModelAndView mv = new ModelAndView("matricula/salvarmatricula");
        mv.addObject("matricula", new MatriculaModel());
        mv.addObject("alunos", alunoService.buscarTodos());
        mv.addObject("cursos", cursoService.buscarTodos());
        return mv;
    }

    @PostMapping("/salvarmatricula")
    public ModelAndView salvar(
            @Valid @ModelAttribute("matricula") MatriculaModel matricula,
            BindingResult result,
            @RequestParam("aluno") Long alunoId,
            @RequestParam("curso") Long cursoId) {

        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("matricula/salvarmatricula");
            mv.addObject("alunos", alunoService.buscarTodos());
            mv.addObject("cursos", cursoService.buscarTodos());
            return mv;
        }

        AlunoModel aluno = alunoService.buscarPorId(alunoId);
        CursoModel curso = cursoService.buscarPorId(cursoId);

        matricula.setAluno(aluno);
        matricula.setCurso(curso);

        matriculaService.inserir(matricula);

        return new ModelAndView("redirect:/mantermatricula");
    }

    @GetMapping("/editarmatricula/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        MatriculaModel matricula = matriculaService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("matricula/salvarmatricula");
        mv.addObject("matricula", matricula);
        mv.addObject("alunos", alunoService.buscarTodos());
        mv.addObject("cursos", cursoService.buscarTodos());
        return mv;
    }

    @GetMapping("/removermatricula/{id}")
    public String remover(@PathVariable Long id,
            RedirectAttributes redirectAttributes) {

        matriculaService.remover(id);

        return "redirect:/mantermatricula";
    }

}
