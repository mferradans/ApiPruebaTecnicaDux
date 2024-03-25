package com.APIEquipos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "liga")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Liga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Ingresa el nombre de la liga")
    private String nombre;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pais",referencedColumnName = "id")
    private Pais pais;


}
