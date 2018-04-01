package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

@Repository
public class ChamadoDAO {
	private Connection conn;
	@PersistenceContext
	EntityManager manager;
	
	public int criarChamado(Chamado chamado) {
		Date dataAbertura = new Date(chamado.getDataAbertura().getTime());
		return 0;
	}

	public List<Chamado> listarChamadosByFila(Fila fila) throws IOException {
		//conectei minha fila com a persistencia
		fila = manager.find(Fila.class, fila.getId());
		
		String jpql = "select c from Chamado c where c.fila = :fila";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("fila", fila);

		List<Chamado> result = query.getResultList();
		return result;
	}

	public void adicionarChamado(int id, String nome) throws IOException {
		Chamado chamado = new Chamado();
		Fila fila = new Fila();
		fila.setId(id);
		chamado.setFila(fila);
		chamado.setNome(nome);
		manager.persist(chamado);
	}
}
