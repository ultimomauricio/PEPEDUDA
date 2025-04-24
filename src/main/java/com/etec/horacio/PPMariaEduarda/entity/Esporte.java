package com.etec.horacio.PPMariaEduarda.entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name = "esporte")
@Getter @Setter
public class Esporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEsporte")
    private int idEsporte;

    @Column(name = "nomeEsporte")
    private String nomeEsporte;

    @Column(name = "descricao")
    private String descricao;
}
