package com.APIEquipos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APIEquipos.model.Pais;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Long>{
    
}
