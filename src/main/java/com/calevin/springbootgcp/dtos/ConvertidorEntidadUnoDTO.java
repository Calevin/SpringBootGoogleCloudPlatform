package com.calevin.springbootgcp.dtos;

import com.calevin.springbootgcp.entidades.EntidadUno;
import org.springframework.stereotype.Component;

@Component
public class ConvertidorEntidadUnoDTO {
    public static GetEntidadUnoDTO convertirEntidadUnoToGetEntidadUno(EntidadUno entidad){
        GetEntidadUnoDTO dto = new GetEntidadUnoDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setCategoriaNombre(entidad.getCategoria().getNombre());

        return dto;
    }
}
