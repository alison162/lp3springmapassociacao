package com.ifms.lp3spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifms.lp3spring.Repository.DepartamentoRepository;
import com.ifms.lp3spring.model.DepartamentoModel;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public String inserir (DepartamentoModel departamento) {
        try {
            departamentoRepository.save(departamento);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Salvo com Sucesso";
    }

    public List<DepartamentoModel> buscarTodos() {
        return departamentoRepository.findAll();
    }

    public String remover(Long id) {
        try {
            departamentoRepository.deleteById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Removido com Sucesso";
    }
    
    public DepartamentoModel buscarPorId(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }


    public DepartamentoRepository getDeparmentoRepository() {
        return departamentoRepository;
    }

    public void setDepartamentoRepository(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }


}
