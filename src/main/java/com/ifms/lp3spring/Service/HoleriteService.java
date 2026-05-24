package com.ifms.lp3spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.lp3spring.Repository.HoleriteRepository;
import com.ifms.lp3spring.model.HoleriteModel;

@Service
public class HoleriteService {


    @Autowired
    private HoleriteRepository holeriteRepository;

    public String inserir (HoleriteModel holerite) {
        try {
            holeriteRepository.save(holerite);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Salvo com Sucesso";
    }

    public List<HoleriteModel> buscarTodos() {
        return holeriteRepository.findAll();
    }

    public String remover(Long id) {
        try {
            holeriteRepository.deleteById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Removido com Sucesso";
    }
    
    public HoleriteModel buscarPorId(Long id) {
        return holeriteRepository.findById(id).orElse(null);
    }


    public HoleriteRepository getHoleriteRepository() {
        return holeriteRepository;
    }

    public void setHoleriteRepository(HoleriteRepository holeriteRepository) {
        this.holeriteRepository = holeriteRepository;
    }


}

    
