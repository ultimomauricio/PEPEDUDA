package com.etec.horacio.PPMariaEduarda.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "evento")
@Getter @Setter
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvento;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idLocal")
    private Localizacao local;

    private String nomeEvento;
    private Date dataEvento;

    @ManyToOne
    @JoinColumn(name = "idAuthor")
    private Usuario author;

    private String partIdNumberEvento;
    private String statusConfirmacao;
    private int status;
    private Date createAt;
    private Date finishedAt;
    private Date updateAt;
    private String idAuto;
}