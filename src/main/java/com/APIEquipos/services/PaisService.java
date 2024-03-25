package com.APIEquipos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.APIEquipos.model.Pais;
import com.APIEquipos.repository.PaisRepository;

import org.springframework.stereotype.Service;

@Service

public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public Pais createPais(Pais pais) {
        return paisRepository.save(pais);
    }

    public Pais getPaisById(Long id) {
        return paisRepository.findById(id).get();
    }
    public List<Pais> getAllPais() {
        return paisRepository.findAll();
    }
    
    public void deletePais(Long id) {
        paisRepository.deleteById(id);
    }
}
