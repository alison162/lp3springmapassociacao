package com.ifms.framespring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.framespring.model.CursoModel;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {
    
}
