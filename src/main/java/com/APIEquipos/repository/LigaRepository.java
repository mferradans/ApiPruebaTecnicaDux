package com.APIEquipos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.APIEquipos.model.Liga;

@Repository
public interface LigaRepository extends JpaRepository<Liga,Long>{
    
}
