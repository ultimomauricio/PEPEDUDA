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
    private int idEsporte;

    private String nomeEsporte;
    private String descricao;
}