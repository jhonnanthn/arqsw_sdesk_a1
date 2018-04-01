package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

@Repository
public class UsuarioDAO {
	@PersistenceContext
	EntityManager manager;

	public Usuario buscaUsuario(Usuario usuario) throws IOException {
		String jpql = "select user from Usuario user where user.nome = :nome and user.password = :password";

		Query query = manager.createQuery(jpql);
		query.setParameter("nome", usuario.getNome());
		query.setParameter("password", usuario.getPassword());

		List<Usuario> result = query.getResultList();
		if(result.size() > 0)	return result.get(0);
		else						return null;
		
	}

}
