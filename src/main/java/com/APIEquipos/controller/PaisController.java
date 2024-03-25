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
import com.APIEquipos.model.Pais;
import com.APIEquipos.services.PaisService;

@RestController
@RequestMapping("/api/paises")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @PostMapping("/crearPais")
    public Pais createPais(@RequestBody Pais pais) {
        return paisService.createPais(pais);
    }
    @GetMapping
    public List<Pais> getAllPais(){
        return paisService.getAllPais();
    }
    @GetMapping("/{id}")
    public Pais getPaisById(@PathVariable("id") Long id){
        return paisService.getPaisById(id);
    }
    @DeleteMapping("/eliminarPais/{id}")
    public void deletePais(@PathVariable("id") Long id){
        paisService.deletePais(id);
        }
}
