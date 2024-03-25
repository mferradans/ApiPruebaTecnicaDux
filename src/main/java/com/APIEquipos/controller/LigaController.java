package com.APIEquipos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APIEquipos.model.Liga;
import com.APIEquipos.services.LigaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ligas")
public class LigaController {
    @Autowired
    private LigaService ligaService;

    @PostMapping("/crearLiga")
    public Liga createLiga(@Valid @RequestBody Liga liga) {
        return ligaService.createLiga(liga);
    }

    @GetMapping()
    public List<Liga> getAllLigas() {
        return ligaService.getAllLiga();
    }

    @GetMapping("/{id}")
    public Liga searchLigaById(@PathVariable("id") Long id) {
        return ligaService.getLigaById(id);
    }

    @DeleteMapping("/eliminarLiga/{id}")
    public void deleteLigaById(@PathVariable("id") Long id) {
        ligaService.deleteLiga(id);
    }
}
