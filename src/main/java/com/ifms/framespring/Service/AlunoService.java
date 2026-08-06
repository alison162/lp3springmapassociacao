package com.ifms.framespring.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.framespring.Repository.AlunoRepository;
import com.ifms.framespring.model.AlunoModel;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public void inserir(AlunoModel aluno) {
        try {
            alunoRepository.save(aluno);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public List<AlunoModel> buscarTodos() {
        return alunoRepository.findAll();
    }

    public void remover(Long id) {
        alunoRepository.deleteById(id);
    }

    public AlunoModel buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public List<AlunoModel> buscarTodosOrdenadosPorNome() {
        List<AlunoModel> alunos = alunoRepository.findAll();
        return alunos;
    }

    public AlunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

}
