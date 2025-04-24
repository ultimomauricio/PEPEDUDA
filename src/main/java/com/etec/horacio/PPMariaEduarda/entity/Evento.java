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
    @Column(name = "idEvento")
    private int idEvento;

    @Column(name = "idUsuario") // FK
    private String idUsuario;

    @Column(name = "idLocal") // FK
    private String idLocal;

    @Column(name = "nomeEvento")
    private String nomeEvento;

    @Column(name = "dataEvento")
    private Date dataEvento;

    @Column(name = "idAmigo") // FK
    private String idAmigo;

    @Column(name = "participantesEvento")
    private String participantesEvento;

    @Column(name = "statusConfirmacao")
    private String statusConfirmacao;

    @Column(name = "status")
    private int status;

    @Column(name = "create_at")
    private Date create_at;

    @Column(name = "finished_at")
    private Date finished_at;

    @Column(name = "update_at")
    private Date update_at;

    @Column(name = "id_autor")
    private int id_autor;
}
