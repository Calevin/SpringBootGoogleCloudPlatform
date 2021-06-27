package com.calevin.springbootgcp.entidades;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "entidad_uno")
@Data
@NoArgsConstructor
public class EntidadUno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    @ManyToOne
    private Categoria categoria;
}
