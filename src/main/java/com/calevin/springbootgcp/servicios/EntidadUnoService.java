package com.calevin.springbootgcp.servicios;

import com.calevin.springbootgcp.entidades.EntidadUno;
import com.calevin.springbootgcp.repositorios.EntidadUnoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class EntidadUnoService extends BaseService<EntidadUno, Long, EntidadUnoRepositorio> {
}
