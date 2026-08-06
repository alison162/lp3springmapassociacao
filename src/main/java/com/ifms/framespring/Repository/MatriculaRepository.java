package com.ifms.framespring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.framespring.model.MatriculaModel;

@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaModel, Long> {
}
    
