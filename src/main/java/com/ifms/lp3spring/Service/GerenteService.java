package com.ifms.lp3spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.lp3spring.Repository.GerenteRepository;
import com.ifms.lp3spring.model.GerenteModel;

@Service
public class GerenteService {
    @Autowired
    private GerenteRepository gerenteRepository;

    public String inserir (GerenteModel gerente) {
        try {
            gerenteRepository.save(gerente);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Salvo com Sucesso";
    }
    
    public List<GerenteModel> buscarTodos() {
        return gerenteRepository.findAll();
    }

    public List<GerenteModel> buscarTodosOrdenadosPorNome() {
        List<GerenteModel> gerentes = gerenteRepository.findAll();
        gerentes.sort((g1, g2) -> g1.getNome().compareToIgnoreCase(g2.getNome()));
        return gerentes;
    }

    public String remover(Long id) {
        try {
            gerenteRepository.deleteById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Removido com Sucesso";
    }
    
    public GerenteModel buscarPorId(Long id) {
        return gerenteRepository.findById(id).orElse(null);
    }

    public GerenteRepository getGerenteRepository() {
        return gerenteRepository;
    }

    public void setGerenteRepository(GerenteRepository gerenteRepository) {
        this.gerenteRepository = gerenteRepository;
    }


}
