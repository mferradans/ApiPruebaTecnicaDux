package com.APIEquipos.services;

import com.APIEquipos.error.EquipoNotFoundException;
import com.APIEquipos.model.Equipo;
import com.APIEquipos.model.Liga;
import com.APIEquipos.model.Pais;
import com.APIEquipos.repository.EquipoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EquipoServiceTest {
    @Autowired
    private EquipoService equipoService;
    @MockBean
    private EquipoRepository equipoRepository;
    @BeforeEach
    void setUp() {
        Pais pais = Pais.builder()
                .nombre("Argentina")
                .build();
        Liga liga = Liga.builder()
                .nombre("LPF")
                .pais(pais)
                .build();
        Equipo equipo = Equipo.builder()
                .nombre("River")
                .liga(liga)
                .build();
        Equipo equipo2 = Equipo.builder()
                .nombre("Talleres")
                .liga(liga)
                .build();

        Mockito.when(equipoRepository.findByNombreIgnoreCase("River")).thenReturn(Optional.of(equipo));

        List<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(equipo);
        listaEquipos.add(equipo2);
        Mockito.when(equipoRepository.findByPais("Argentina")).thenReturn(Optional.of(listaEquipos));

    }



    @Test
    @DisplayName("Prueba para obtener un equipo al enviar un nombre.")
    public void findByNombreIgnoreCase()throws EquipoNotFoundException  {
        String equipoNombre="River";
        Equipo equipo = equipoService.findByNombreIgnoreCase(equipoNombre);
        assertEquals(equipoNombre,equipo.getNombre());
        System.out.println("Equipo: "+equipo);
    }

    @Test
    @DisplayName("Prueba para obtener equipos que pertenezcan a la liga del pais enviado.")
    public void findByPais()throws EquipoNotFoundException  {
        String paisNombre="Argentina";
        List<Equipo> listaEquipos = equipoService.findEquipoByPais(paisNombre);
        for (Equipo equipo:listaEquipos){
            assertEquals(paisNombre,equipo.getLiga().getPais().getNombre());
            System.out.println("Equipo: "+equipo);
        }
    }

}