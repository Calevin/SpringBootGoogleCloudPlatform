package com.calevin.springbootgcp.servicios;

import com.calevin.springbootgcp.entidades.EntidadUno;
import com.calevin.springbootgcp.repositorios.EntidadUnoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadUnoService extends BaseService<EntidadUno, Long, EntidadUnoRepositorio> {
    public List<EntidadUno> obtenerClubesPorCategoria(Long categoriaId){
        return this.repositorio.buscarPorCategoria(categoriaId);
    }
}
