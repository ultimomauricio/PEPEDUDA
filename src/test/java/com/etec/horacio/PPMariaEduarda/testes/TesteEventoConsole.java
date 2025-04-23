package com.etec.horacio.PPMariaEduarda.testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Scanner;

public class TesteEventoConsole {
    private static EventoRepository eventoRepo;
    private static Scanner scanner;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NomeDaUnidadeDePersistencia");
        EntityManager em = emf.createEntityManager();
        eventoRepo = new EventoRepository();
        eventoRepo.entityManager = em;
        scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n=== MENU EVENTO ===");
            System.out.println("1. Cadastrar Evento");
            System.out.println("2. Buscar Evento por ID");
            System.out.println("3. Listar Eventos");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEvento();
                    break;
                case 2:
                    buscarEventoPorId();
                    break;
                case 3:
                    listarEventos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        em.close();
        emf.close();
        scanner.close();
    }

    private static void cadastrarEvento() {
        System.out.println("\n--- CADASTRO DE EVENTO ---");
        Evento evento = new Evento();

        System.out.print("Nome do Evento: ");
        evento.setNomeEvento(scanner.nextLine());

        System.out.print("ID do Usuário Organizador: ");
        // Na implementação real, deveria buscar o usuário
        int idUsuario = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID do Local: ");
        int idLocal = scanner.nextInt();
        scanner.nextLine();

        // Configurar outras propriedades do evento

        em.getTransaction().begin();
        eventoRepo.salvar(evento);
        em.getTransaction().commit();

        System.out.println("Evento cadastrado com ID: " + evento.getIdEvento());
    }

    private static void buscarEventoPorId() {
        System.out.print("\nDigite o ID do evento: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Evento evento = eventoRepo.buscarPorId(id);
        if (evento != null) {
            System.out.println("Evento encontrado:");
            System.out.println("ID: " + evento.getIdEvento());
            System.out.println("Nome: " + evento.getNomeEvento());
        } else {
            System.out.println("Evento não encontrado!");
        }
    }

    private static void listarEventos() {
        System.out.println("\n--- LISTA DE EVENTOS ---");
        // Implementação similar à listarUsuarios()
        System.out.println("Funcionalidade a ser implementada no repositório");
    }
}
