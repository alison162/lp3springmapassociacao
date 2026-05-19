package com.ifms.lp3spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.lp3spring.Repository.CoordenadorRepository;
import com.ifms.lp3spring.model.CoordenadorModel;


@Service
public class CoordenadorService {
     @Autowired
    private CoordenadorRepository coordenadorRepository;

    public String inserir (CoordenadorModel coordenador) {
        try {
            coordenadorRepository.save(coordenador);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Salvo com Sucesso";
    }
    
    public CoordenadorRepository getCoordenadorRepository() {
        return coordenadorRepository;
    }

    public void setAlunoRepository(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

}
