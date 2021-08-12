package com.llantoy.RetoTecnico.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente implements Serializable {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;

    private String nombre;
    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "numero_documento")
    private String numero_documento;
}
