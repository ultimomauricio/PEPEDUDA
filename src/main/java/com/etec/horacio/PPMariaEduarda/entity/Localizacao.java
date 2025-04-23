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
    private int idLocal;

    private String nomeLocal;
    private String codLocal;
    private String idStudentLocal;
    private String longlistedLocal;

    @ManyToOne
    @JoinColumn(name = "idEsporte")
    private Esporte esporte;

    private String idf;
}