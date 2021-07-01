package com.calevin.springbootgcp.controladores;

import com.calevin.springbootgcp.entidades.EntidadUno;
import com.calevin.springbootgcp.servicios.EntidadUnoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<EntidadUno> obtenerTodos() {
        return entidadUnoService.findAll();
    }

    /**
     * Obtenemos un registro en base a su ID
     *
     * @param id
     * @return Null si no encuentra el registro
     */
    @GetMapping("/entidadUno/{id}")
    public EntidadUno obtenerUno(@PathVariable Long id) {
        return entidadUnoService.findById(id).orElse(null);
    }

    /**
     * Insertamos un nuevo registro
     *
     * @param nuevo
     * @return registro insertado
     */
    @PostMapping("/entidadUno")
    public EntidadUno nuevoRegistro(@RequestBody EntidadUno nuevo) {
        return entidadUnoService.save(nuevo);
    }

    /**
     * Editamos un registro
     *
     * @param editar
     * @param id
     * @return registro editado
     */
    @PutMapping("/entidadUno/{id}")
    public EntidadUno editarRegistro(@RequestBody EntidadUno editar, @PathVariable Long id) {
        return entidadUnoService
                .findById(id)
                .map( p -> {
                    editar.setId(id);
                    System.out.println(editar);
                    return entidadUnoService.save(editar);
                })
                .orElse(null);
    }

    /**
     * Borra un registro
     *
     * @param id
     * @return
     */
    @DeleteMapping("/entidadUno/{id}")
    public EntidadUno borrarRegistro(@PathVariable Long id) {
        return entidadUnoService
                .findById(id)
                .map( p -> {
                    entidadUnoService.deleteById(id);
                    return p;
                })
                .orElse(null);
    }
}
