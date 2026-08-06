package com.ifms.framespring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.framespring.Repository.MatriculaRepository;
import com.ifms.framespring.model.MatriculaModel;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public String inserir(MatriculaModel matricula) {
        try {

            matriculaRepository.save(matricula);

        } catch (Exception e) {
            return e.getMessage();
        }
        return "Salvo com Sucesso";
    }

    public List<MatriculaModel> buscarTodos() {
        return matriculaRepository.findAll();
    }

    public String remover(Long id) {

        MatriculaModel matricula = matriculaRepository.findById(id).orElse(null);

        if (matricula == null) {
            return "Matrícula não encontrada";
        }
        matriculaRepository.deleteById(id);

        return "Matrícula removida com sucesso";
    }

    public MatriculaModel buscarPorId(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    public MatriculaRepository getMatriculaRepository() {
        return matriculaRepository;
    }

    public void setMatriculaRepository(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

}
