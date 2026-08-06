package com.ifms.framespring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.framespring.Repository.CursoRepository;
import com.ifms.framespring.model.CursoModel;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public String inserir(CursoModel curso) {
        try {
            cursoRepository.save(curso);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Salvo com Sucesso";
    }

    public List<CursoModel> buscarTodos() {
        return cursoRepository.findAll();
    }

    public String remover(Long id) {

        CursoModel curso = cursoRepository.findById(id).orElse(null);

        if (curso == null) {
            return "Curso não encontrado";
        }

        if (!curso.getMatriculas().isEmpty()) {
            return "Não é possível remover este curso pois existem matrículas vinculadas.";
        }

        cursoRepository.deleteById(id);

        return "Curso removido com sucesso";
    }

    public CursoModel buscarPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public CursoRepository getCursoRepository() {
        return cursoRepository;
    }

    public void setCursoRepository(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

}
