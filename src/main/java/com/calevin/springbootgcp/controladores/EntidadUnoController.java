package com.calevin.springbootgcp.controladores;

import com.calevin.springbootgcp.entidades.EntidadUno;
import com.calevin.springbootgcp.servicios.EntidadUnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntidadUnoController {

    private final EntidadUnoService entidadUnoService;

    @Autowired
    public EntidadUnoController(EntidadUnoService entidadUnoService) {
        this.entidadUnoService = entidadUnoService;
    }

    @GetMapping("/entidadUno")
    public List<EntidadUno> obtenerTodos() {
        return entidadUnoService.findAll();
    }
}
