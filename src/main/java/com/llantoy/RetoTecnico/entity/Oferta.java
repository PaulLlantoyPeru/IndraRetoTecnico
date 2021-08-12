package com.llantoy.RetoTecnico.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Oferta implements Serializable {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name = "codigo_oferta")
    private int codigo_oferta;

    @Column(name = "descripcion_oferta")
    private String descripcion_oferta;

    @Column(name = "fecha_inicio")
    private Date fecha_inicio;

    @Column(name = "fecha_fin")
    private Date fecha_fin;

}
