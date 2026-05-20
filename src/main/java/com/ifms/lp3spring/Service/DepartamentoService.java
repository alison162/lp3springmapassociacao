package com.ifms.lp3spring.Service;

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
    
    public DepartamentoRepository getDeparmentoRepository() {
        return departamentoRepository;
    }

    public void setDepartamentoRepository(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }


}
