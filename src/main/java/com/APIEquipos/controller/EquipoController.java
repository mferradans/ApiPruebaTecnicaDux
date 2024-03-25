package com.APIEquipos.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APIEquipos.error.EquipoNotFoundException;
import com.APIEquipos.model.Equipo;
import com.APIEquipos.services.EquipoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @Operation(summary = "Mostrar equipo por nombre ingresado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipo mostrado con éxito.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Equipo.class))),
            @ApiResponse(responseCode = "404", description = "Equipo no encontrado")
    })
    @GetMapping("/buscarxNombre/{nombre}")
    Equipo findEquipoByName(@Parameter(description = "nombre de equipo", example = "Malaga")@PathVariable("nombre") String nombre) throws EquipoNotFoundException {
        return equipoService.findByNombreIgnoreCase(nombre);

    }
    @Operation(summary = "Mostrar todos los equipos que pertenezcan a una liga del pais ingresado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipos mostrados con éxito.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Equipo.class))),
            @ApiResponse(responseCode = "404", description = "Equipo no encontrado")
    })
    @GetMapping("/buscarxPais/{nombre}")
    List<Equipo> findEquipoByPais(@Parameter(description = "nombre de país", example = "Italia") @PathVariable("nombre") String nombre) {
        return equipoService.findEquipoByPais(nombre);

    }
    @Operation(summary = "Crear un equipo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Equipo creado con éxito",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Equipo.class))),
            @ApiResponse(responseCode = "400", description = "La solicitud es invalida")
    })
    @PostMapping("/crearEquipo")
    public Equipo createEquipo(@Valid @RequestBody Equipo equipo) throws EquipoNotFoundException {
        return equipoService.createEquipo(equipo);
    }


    @Operation(summary = "Obtener todos los equipos")
    @GetMapping
    public List<Equipo> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    @Operation(summary = "Mostrar equipo por id ingresado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Equipo mostrado con éxito.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Equipo.class))),
            @ApiResponse(responseCode = "404", description = "Equipo no encontrado")
    })
    @GetMapping("/{id}")
    public Equipo searchEquipoById(@PathVariable("id") Long id) throws EquipoNotFoundException {
        return equipoService.getEquipoById(id);
    }

    @Operation(summary = "Eliminar un equipo por id ingresado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Equipo eliminado con éxito.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Equipo.class))),
            @ApiResponse(responseCode = "404", description = "Equipo no encontrado")
    })
    @DeleteMapping("/eliminarEquipo/{id}")
    public void deleteEquipoById(@PathVariable("id") Long id) throws EquipoNotFoundException {
        equipoService.deleteEquipo(id);
    }

    @Operation(summary = "Editar un equipo por id ingresado")
    @PutMapping("/editarEquipo/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable("id") Long equipoId, @RequestBody Equipo equipoActualizado)
            throws EquipoNotFoundException {
        return ResponseEntity.ok(equipoService.updateEquipo(equipoId, equipoActualizado));
    }

    @GetMapping("/public")
    public String sayHello(){
        return "FUNCIONA EL PUBLICO";
    }

}
