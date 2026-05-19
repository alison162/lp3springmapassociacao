package com.ifms.lp3spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.lp3spring.model.GerenteModel;

@Repository
public interface GerenteRepository extends JpaRepository<GerenteModel, Long> {
    
}
