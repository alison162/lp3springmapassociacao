package com.ifms.lp3spring.Service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifms.lp3spring.Comparator.FuncionarioNome;
import com.ifms.lp3spring.model.FuncionarioModel;
import com.ifms.lp3spring.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public String inserir(FuncionarioModel funcionario) {
        try {
            funcionarioRepository.save(funcionario);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "Funcionário salvo com sucesso!";
    }


    public List<FuncionarioModel> buscarTodos() {
        return funcionarioRepository.findAll();
    }

 
    public FuncionarioModel buscarPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

     public List<FuncionarioModel> buscarTodosOrdenadosPorNome() {
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        Collections.sort(funcionarios, new FuncionarioNome());
        return funcionarios;
    }
 
    public void remover(Long id) {
        funcionarioRepository.deleteById(id);
    }


    public String atualizar(FuncionarioModel funcionario) {
        try {
            funcionarioRepository.save(funcionario);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "Funcionário atualizado com sucesso!";
    }
}