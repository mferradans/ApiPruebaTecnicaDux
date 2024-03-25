package com.APIEquipos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.APIEquipos.model.Liga;
import org.springframework.beans.factory.annotation.Autowired;

import com.APIEquipos.error.EquipoNotFoundException;
import com.APIEquipos.model.Equipo;
import com.APIEquipos.repository.EquipoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;
    public Equipo createEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo getEquipoById(Long id) throws EquipoNotFoundException {
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);
        if (!optionalEquipo.isPresent()) {
            throw new EquipoNotFoundException("Equipo no encontrado");
        }
        return optionalEquipo.get();
    }

    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    public void deleteEquipo(Long id) throws EquipoNotFoundException {
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);
        if (!optionalEquipo.isPresent()) {
            throw new EquipoNotFoundException("Equipo no encontrado");
        } else {
            equipoRepository.deleteById(id);
        }
    }

    public List<Equipo> findEquipoByPais(String nombre) {
        Optional<List<Equipo>> optionalEquipos = equipoRepository.findByPais(nombre);
        return optionalEquipos.get();
    }

    public Equipo findByNombreIgnoreCase(String nombre) throws EquipoNotFoundException {
        Optional<Equipo> optionalEquipo = equipoRepository.findByNombreIgnoreCase(nombre);
        if (!optionalEquipo.isPresent()) {
            throw new EquipoNotFoundException("Equipo no encontrado");
        }
        return optionalEquipo.get();
    }

    public Equipo updateEquipo(Long id, Equipo newEquipo) throws EquipoNotFoundException {
        Optional<Equipo> optionalEquipo = equipoRepository.findById(id);
        if (!optionalEquipo.isPresent()) {
            throw new EquipoNotFoundException("Equipo no existente");
        } else {
            Equipo equipo = this.getEquipoById(id);
            equipo.setNombre(newEquipo.getNombre());
            equipo.setLiga(newEquipo.getLiga());
            return equipoRepository.save(equipo);
        }

    }


}
