package com.calevin.springbootgcp.repositorios;

import com.calevin.springbootgcp.entidades.EntidadUno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntidadUnoRepositorio extends JpaRepository<EntidadUno, Long> {

    @Query("from EntidadUno c where c.categoria.id = ?1 order by c.nombre")
    List<EntidadUno> buscarPorCategoria(Long categoriaId);

}
