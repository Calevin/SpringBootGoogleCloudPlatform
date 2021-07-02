package com.calevin.springbootgcp.controladores;

import com.calevin.springbootgcp.entidades.EntidadUno;
import com.calevin.springbootgcp.servicios.EntidadUnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntidadUnoController {

    private final EntidadUnoService entidadUnoService;

    @Autowired
    public EntidadUnoController(EntidadUnoService entidadUnoService) {
        this.entidadUnoService = entidadUnoService;
    }

    /**
     * Obtenemos todos los registro
     *
     * @return
     */
    @GetMapping("/entidadUno")
    public ResponseEntity<List<EntidadUno>> obtenerTodos() {
        List<EntidadUno> entidades = entidadUnoService.findAll();
        if (entidades.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(entidades);
        }
    }

    /**
     * Obtenemos un registro en base a su ID
     *
     * @param id
     * @return Null si no encuentra el registro
     */
    @GetMapping("/entidadUno/{id}")
    public ResponseEntity<EntidadUno> obtenerUno(@PathVariable Long id) {
        return entidadUnoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    /**
     * Insertamos un nuevo registro
     *
     * @param nuevo
     * @return registro insertado
     */
    @PostMapping("/entidadUno")
    public ResponseEntity<EntidadUno> nuevoRegistro(@RequestBody EntidadUno nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entidadUnoService.save(nuevo));
    }

    /**
     * Editamos un registro
     *
     * @param editar
     * @param id
     * @return registro editado
     */
    @PutMapping("/entidadUno/{id}")
    public ResponseEntity<EntidadUno> editarRegistro(@RequestBody EntidadUno editar, @PathVariable Long id) {
        return entidadUnoService
                .findById(id)
                .map( p -> {
                    editar.setId(id);
                    return ResponseEntity.ok(entidadUnoService.save(editar));
                })
                .orElse(ResponseEntity.noContent().build());
    }

    /**
     * Borra un registro
     *
     * @param id
     * @return
     */
    @DeleteMapping("/entidadUno/{id}")
    public ResponseEntity<?> borrarRegistro(@PathVariable Long id) {
        return entidadUnoService
                .findById(id)
                .map( p -> {
                    entidadUnoService.deleteById(id);
                    return ResponseEntity.status(HttpStatus.OK).build();
                })
                .orElse(ResponseEntity.noContent().build());
    }
}
