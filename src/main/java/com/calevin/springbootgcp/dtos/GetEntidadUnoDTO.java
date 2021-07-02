package com.calevin.springbootgcp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetEntidadUnoDTO {
    private long id;
    private String nombre;
    private String categoriaNombre;
}
