package com.etec.horacio.PPMariaEduarda.testes;

import com.etec.horacio.PPMariaEduarda.Repository.UsuarioRepository;
import com.etec.horacio.PPMariaEduarda.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TesteUsuarioConsole {
    private static UsuarioRepository usuarioRepo;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Configuração inicial
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NomeDaUnidadeDePersistencia");
        EntityManager em = emf.createEntityManager();
        usuarioRepo = new UsuarioRepository();
        usuarioRepo.entityManager = em;
        scanner = new Scanner(System.in);

        // Menu principal
        int opcao;
        do {
            System.out.println("\n=== MENU USUÁRIO ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Buscar Usuário por ID");
            System.out.println("3. Listar Todos Usuários");
            System.out.println("4. Atualizar Usuário");
            System.out.println("5. Excluir Usuário");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    buscarUsuarioPorId();
                    break;
                case 3:
                    listarUsuarios();
                    break;
                case 4:
                    atualizarUsuario();
                    break;
                case 5:
                    excluirUsuario();
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

    private static void cadastrarUsuario() {
        System.out.println("\n--- CADASTRO DE USUÁRIO ---");
        Usuario usuario = new Usuario();

        System.out.print("Nome: ");
        usuario.setNome(scanner.nextLine());

        System.out.print("Email: ");
        usuario.setEmail(scanner.nextLine());

        System.out.print("Número Celular: ");
        usuario.setNumCelular(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Senha: ");
        usuario.setSenha(scanner.nextLine());

        usuario.setDate(new Date());
        usuario.setAdmin(false);

        EntityManager em = null;
        em.getTransaction().begin();
        usuarioRepo.salvar(usuario);
        em.getTransaction().commit();

        System.out.println("Usuário cadastrado com ID: " + usuario.getIdUsuario());
    }

    private static void buscarUsuarioPorId() {
        System.out.print("\nDigite o ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = usuarioRepo.buscarPorId(id);
        if (usuario != null) {
            System.out.println("Usuário encontrado:");
            System.out.println("ID: " + usuario.getIdUsuario());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Email: " + usuario.getEmail());
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    private static void listarUsuarios() {
        System.out.println("\n--- LISTA DE USUÁRIOS ---");
        List<Usuario> usuarios = usuarioRepo.listarTodos();
        usuarios.forEach(u -> System.out.println(u.getIdUsuario() + " - " + u.getNome()));
        System.out.println("Funcionalidade a ser implementada no repositório");
    }

    private static void atualizarUsuario() {
        System.out.print("\nDigite o ID do usuário para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = usuarioRepo.buscarPorId(id);
        if (usuario != null) {
            System.out.print("Novo nome (" + usuario.getNome() + "): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                usuario.setNome(novoNome);
            }

            em.getTransaction().begin();
            usuarioRepo.atualizar(usuario);
            em.getTransaction().commit();
            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    private static void excluirUsuario() {
        System.out.print("\nDigite o ID do usuário para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        em.getTransaction().begin();
        usuarioRepo.excluir(id);
        em.getTransaction().commit();
        System.out.println("Usuário excluído com sucesso!");
    }
}