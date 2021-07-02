package com.calevin.springbootgcp.controladores;

import com.calevin.springbootgcp.dtos.ConvertidorEntidadUnoDTO;
import com.calevin.springbootgcp.dtos.GetEntidadUnoDTO;
import com.calevin.springbootgcp.entidades.EntidadUno;
import com.calevin.springbootgcp.errores.NotFoundException;
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
    public ResponseEntity<GetEntidadUnoDTO> obtenerUno(@PathVariable Long id) {
        return entidadUnoService.findById(id)
                .map(ConvertidorEntidadUnoDTO::convertirEntidadUnoToGetEntidadUno)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException(id));
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
                .orElseThrow(() -> new NotFoundException(id));
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
                .orElseThrow(() -> new NotFoundException(id));
    }
}
