package com.ifms.lp3spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifms.lp3spring.Repository.CoordenadorRepository;
import com.ifms.lp3spring.model.CoordenadorModel;
import com.ifms.lp3spring.model.GerenteModel;



@Service
public class CoordenadorService {
     @Autowired
    private CoordenadorRepository coordenadorRepository;

    public void inserir (CoordenadorModel coordenador) {
        try {
            coordenadorRepository.save(coordenador);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    

    public List<CoordenadorModel> buscarTodos() {
        return coordenadorRepository.findAll();
    }

    public void remover(Long id) {
        try {
            coordenadorRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    public CoordenadorModel buscarPorId(Long id) {
        return coordenadorRepository.findById(id).orElse(null);
    }


    public List<CoordenadorModel> buscarTodosOrdenadosPorNome() {
        List<CoordenadorModel> coordenadores = coordenadorRepository.findAll();
        coordenadores.sort((c1, c2) -> c1.getNome().compareToIgnoreCase(c2.getNome()));
        return coordenadores;
    }

    public CoordenadorRepository getCoordenadorRepository() {
        return coordenadorRepository;
    }

    public void setCoordenadorRepository(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

}
