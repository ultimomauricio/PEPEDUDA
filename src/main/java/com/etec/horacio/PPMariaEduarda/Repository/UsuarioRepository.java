package com.etec.horacio.PPMariaEduarda.Repository;

import com.etec.horacio.PPMariaEduarda.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioRepository {
    private final EntityManager em;

    public UsuarioRepository(EntityManager em) {
        this.em = em;
    }

    public Usuario save(Usuario usuario) {
        if (usuario.getIdUsuario() == 0) {
            em.persist(usuario);
        } else {
            usuario = em.merge(usuario);
        }
        return usuario;
    }

    public Usuario findById(int id) {
        return em.find(Usuario.class, id);
    }

    public List<Usuario> findAll() {
        return em.createQuery("SELECT usuario FROM Usuario usuario", Usuario.class)
                .getResultList();
    }

    public void delete(int id) {
        Usuario usuario = findById(id);
        if (usuario != null) {
            em.remove(usuario);
        }
    }

}
