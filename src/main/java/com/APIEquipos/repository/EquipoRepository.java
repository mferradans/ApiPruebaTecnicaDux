package com.APIEquipos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.APIEquipos.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    // Inversion de dependencia
    Optional<Equipo> findByNombreIgnoreCase(String nombre);

    // JPQL Es el lenguaje que usa Spring Data JPA para realizar la persistencia
    @Query("SELECT e FROM Equipo e WHERE e.liga.pais.nombre = :nombre")
    Optional<List<Equipo>> findByPais(String nombre);
}
