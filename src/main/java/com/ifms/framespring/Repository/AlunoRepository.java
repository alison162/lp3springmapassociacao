package com.ifms.framespring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.framespring.model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
    
}
