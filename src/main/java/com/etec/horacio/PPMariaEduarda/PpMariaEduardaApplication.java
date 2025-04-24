package com.etec.horacio.PPMariaEduarda;

import com.etec.horacio.PPMariaEduarda.entity.Esporte;
import com.etec.horacio.PPMariaEduarda.entity.Evento;
import com.etec.horacio.PPMariaEduarda.entity.Localizacao;
import com.etec.horacio.PPMariaEduarda.entity.Usuario;
import com.etec.horacio.PPMariaEduarda.Enum.StatusEvento;

import java.util.Date;

public class Teste {

	public static void main(String[] args) {

		Esporte esporte = new Esporte();
		esporte.setNomeEsporte("Futebol");
		esporte.setDescricao("Esporte jogado com bola em campo");

		Usuario usuario = new Usuario();
		usuario.setEmail("mariaeduarda@gmail.com");
		usuario.setNumCelular(123456789);
		usuario.setNome("Maria Eduarda");
		usuario.setSenha("senha123");
		usuario.setStatusUsuario(StatusUsuario.ATIVO.name());
		usuario.setAnexoCelular(0);
		usuario.setDate(new Date());
		usuario.setAdmin(true);
		usuario.setBlog("www.dudamariablog.com");

		Localizacao localizacao = new Localizacao();
		localizacao.setNomeLocal("Estádio Municipal");
		localizacao.setCodLocal("EM001");
		localizacao.setIdStudentLocal("1234");
		localizacao.setLonglistedLocal("Sim");
		localizacao.setEsporte(esporte);

		Evento evento = new Evento();
		evento.setNomeEvento("Campeonato Regional");
		evento.setDataEvento(new Date());
		evento.setUsuario(usuario);
		evento.setLocal(localizacao);
		evento.setAuthor(usuario);
		evento.setStatusConfirmacao(StatusEvento.PENDENTE.name());
		evento.setStatus(1);
		evento.setCreateAt(new Date());
		evento.setFinishedAt(new Date());
		evento.setUpdateAt(new Date());
		evento.setIdAuto("EVT123");

		System.out.println("Esporte: " + esporte.getNomeEsporte());
		System.out.println("Descrição do esporte: " + esporte.getDescricao());

		System.out.println("\nUsuário: " + usuario.getNome());
		System.out.println("Email: " + usuario.getEmail());
		System.out.println("Status do usuário: " + usuario.getStatusUsuario());

		System.out.println("\nLocalização: " + localizacao.getNomeLocal());
		System.out.println("Código do local: " + localizacao.getCodLocal());

		System.out.println("\nEvento: " + evento.getNomeEvento());
		System.out.println("Data do evento: " + evento.getDataEvento());
		System.out.println("Status do evento: " + evento.getStatusConfirmacao());
		System.out.println("Organizador: " + evento.getUsuario().getNome());
		System.out.println("Local: " + evento.getLocal().getNomeLocal());

	}
}
