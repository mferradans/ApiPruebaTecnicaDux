package com.APIEquipos.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@Entity
@Table(name = "equipo")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Añade el nombre del equipo")
    private String nombre;

    @Valid
    @ManyToOne( optional = false)
    @JoinColumn(name = "id_liga",referencedColumnName = "id")
    private Liga liga;



}
