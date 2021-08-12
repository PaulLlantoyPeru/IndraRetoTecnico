package com.llantoy.RetoTecnico.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Linea implements Serializable {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "numero_telefono")
    private String numero_telefono;

    @Column(name = "estado")
    private Boolean estado; //true o false

    @Column(name = "nombre_plan")
    private String nombre_plan;
}
