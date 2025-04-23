package com.etec.horacio.PPMariaEduarda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "usuario")
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String email;
    private int numCelular;

    private String nome;

    private String senha;

    private String statusUsuario;

    private int anexoCelular;

    private Date date;

    private boolean isAdmin;

    private String blog;
}