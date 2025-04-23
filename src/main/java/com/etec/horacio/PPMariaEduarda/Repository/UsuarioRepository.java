package com.etec.horacio.PPMariaEduarda.Repository;

import com.etec.horacio.PPMariaEduarda.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UsuarioRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public void salvar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    public Usuario buscarPorId(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Transactional
    public void atualizar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Transactional
    public void excluir(int id) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

    public List<Usuario> listarTodos() {
    }
}