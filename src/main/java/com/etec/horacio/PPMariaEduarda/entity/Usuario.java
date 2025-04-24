package com.etec.horacio.PPMariaEduarda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private int idUsuario;

    @Column(name = "email")
    private String email;

    @Column(name = "NumCelular")
    private int numCelular;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

    @Column(name = "statusUsuario")
    private String statusUsuario;

    @Column(name = "NumeroCelular")
    private int numeroCelular;

    @Column(name = "ddd")
    private int ddd;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    @Column(name = "foto")
    private String foto;
}