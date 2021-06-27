package com.calevin.springbootgcp.repositorios;

import com.calevin.springbootgcp.entidades.EntidadUno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadUnoRepositorio extends JpaRepository<EntidadUno, Long> {
}
