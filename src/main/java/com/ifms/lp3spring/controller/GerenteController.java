package com.ifms.lp3spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifms.lp3spring.Service.GerenteService;
import com.ifms.lp3spring.model.Cargo;
import com.ifms.lp3spring.model.GerenteModel;
import jakarta.validation.Valid;

@Controller
public class GerenteController {
    @Autowired
    private GerenteService gerenteService;

    @GetMapping("/salvargerente")
    public ModelAndView getSalvar() {
        return new ModelAndView("gerente/salvargerente", "gerente", new GerenteModel());
    }

    @PostMapping("/salvargerente")
    public String postSalvar(@Valid @ModelAttribute("gerente") GerenteModel gerente,
            BindingResult result, Model model) {

        System.out.println("ENTROU NO POST");

       if (result.hasErrors()) {

    model.addAttribute("temErro", true);
    model.addAttribute("erros", result.getAllErrors());

    return "gerente/salvargerente";
}

        gerente.setCargo(Cargo.GERENTE);
        gerenteService.inserir(gerente);

        return "redirect:/mantergerente";
    }

    @GetMapping("/mantergerente")
    public ModelAndView buscar() {
        return new ModelAndView("gerente/buscargerente", "gerentes", gerenteService.buscarTodosOrdenadosPorNome());
    }

    @GetMapping("/removergerente/{id}")
    public String remover(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

        try {

            gerenteService.remover(id);

            redirectAttributes.addFlashAttribute(
                    "sucesso",
                    "Gerente removido com sucesso!");

        } catch (DataIntegrityViolationException e) {

            redirectAttributes.addFlashAttribute(
                    "erro",
                    "Não é possível excluir este gerente pois ele está vinculado a um relacionamento.");

        } catch (Exception e) {

            redirectAttributes.addFlashAttribute(
                    "erro",
                    "Erro ao remover gerente.");
        }

        return "redirect:/mantergerente";
    }

    @GetMapping("/salvargerente/{id}")
    public ModelAndView buscarPorId(@PathVariable("id") Long id) {
        GerenteModel gerente = gerenteService.buscarPorId(id);
        if (gerente == null) {
            gerente = new GerenteModel();
        }
        gerente.setCargo(Cargo.GERENTE);
        return new ModelAndView("gerente/salvargerente", "gerente", gerente);
    }

    public GerenteService getGerenteService() {
        return gerenteService;
    }

    public void setGerenteService(GerenteService gerenteService) {
        this.gerenteService = gerenteService;
    }
}