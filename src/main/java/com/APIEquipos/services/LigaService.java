package com.APIEquipos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.APIEquipos.model.Liga;
import com.APIEquipos.repository.LigaRepository;
import org.springframework.stereotype.Service;

@Service

public class LigaService {
    @Autowired
    private LigaRepository ligaRepository;

    public Liga createLiga(Liga liga) {
        return ligaRepository.save(liga);
    }
    public Liga getLigaById(Long id) {
        return ligaRepository.findById(id).get();
    }
    public List<Liga> getAllLiga(){
        return ligaRepository.findAll();
    }
    public void deleteLiga(Long id) {
        ligaRepository.deleteById(id);
    }
}
