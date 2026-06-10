package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.dao.DataIntegrityViolationException;
import com.ifms.lp3spring.Service.CoordenadorService;
import com.ifms.lp3spring.Service.DepartamentoService;
import com.ifms.lp3spring.model.Cargo;
import com.ifms.lp3spring.model.CoordenadorModel;

import jakarta.validation.Valid;

@Controller
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    @Autowired
    private DepartamentoService departamentoService;


    @GetMapping("/salvarcoordenador")
    public ModelAndView getSalvar() {
        ModelAndView mv = new ModelAndView("coordenador/salvarcoordenador");
        mv.addObject("coordenador", new CoordenadorModel());
        mv.addObject("departamentos", departamentoService.buscarTodos());
        return mv;
    }


    @PostMapping("/salvarcoordenador")
    public ModelAndView salvar(@Valid @ModelAttribute("coordenador") CoordenadorModel coordenador,
            BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("coordenador/salvarcoordenador");
            mv.addObject("departamentos", departamentoService.buscarTodos());
            return mv;
        }
        
        coordenador.setCargo(Cargo.COORDENADOR);
        coordenadorService.inserir(coordenador);
        return new ModelAndView("redirect:/mantercoordenador");
    }


    @GetMapping("/mantercoordenador")
    public ModelAndView buscar() {
        return new ModelAndView("coordenador/buscarcoordenador", "coordenadores", coordenadorService.buscarTodosOrdenadosPorNome());
    }


    @GetMapping("/editarcoordenador/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        CoordenadorModel coord = coordenadorService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("coordenador/salvarcoordenador");
        mv.addObject("coordenador", coord);
        mv.addObject("departamentos", departamentoService.buscarTodos());
        return mv;
    }

@GetMapping("/removercoordenador/{id}")
public String remover(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

    try {

        coordenadorService.remover(id);

        redirectAttributes.addFlashAttribute(
                "sucesso",
                "Coordenador removido com sucesso!"
        );

    } catch (DataIntegrityViolationException e) {

        redirectAttributes.addFlashAttribute(
                "erro",
                "Não é possível excluir este coordenador pois ele está vinculado a um relacionamento."
        );

    } catch (Exception e) {

        redirectAttributes.addFlashAttribute(
                "erro",
                "Erro ao remover coordenador."
        );
    }

    return "redirect:/mantercoordenador";
}

    public CoordenadorService getCoordenadorService() {
        return coordenadorService;
    }

    public void setCoordenadorService(CoordenadorService coordenadorService) {
        this.coordenadorService = coordenadorService;
    }

    public DepartamentoService getDepartamentoService() {
        return departamentoService;
    }

    public void setDepartamentoService(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

}