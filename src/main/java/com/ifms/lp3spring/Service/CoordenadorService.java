package com.ifms.lp3spring.Service;

import java.util.List;

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
    

    public List<CoordenadorModel> buscarTodos() {
        return coordenadorRepository.findAll();
    }

    public String remover(Long id) {
        try {
            coordenadorRepository.deleteById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Removido com Sucesso";
    }
    
    public CoordenadorModel buscarPorId(Long id) {
        return coordenadorRepository.findById(id).orElse(null);
    }


    public CoordenadorRepository getCoordenadorRepository() {
        return coordenadorRepository;
    }

    public void setCoordenadorRepository(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

}
