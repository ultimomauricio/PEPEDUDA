package com.etec.horacio.PPMariaEduarda.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name = "localizacao")
@Getter @Setter
public class Localizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLocal")
    private int idLocal;

    @Column(name = "nomeLocal")
    private String nomeLocal;

    @Column(name = "cepLocal")
    private String cepLocal;

    @Column(name = "latitudeLocal")
    private String latitudeLocal;

    @Column(name = "longitudeLocal")
    private String longitudeLocal;

    @Column(name = "idEsporte") // FK
    private String idEsporte;

    @Column(name = "UF")
    private String UF;
}
