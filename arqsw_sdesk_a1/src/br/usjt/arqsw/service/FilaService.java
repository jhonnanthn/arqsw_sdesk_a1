package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.FilaDAO;
import br.usjt.arqsw.entity.Fila;

@Service
public class FilaService {
	private FilaDAO dao;
	
	@Autowired
	public FilaService(FilaDAO dao) {
		this.dao = dao;
	}
	public List<Fila> listarFilas() throws IOException{
		return dao.listarFilas();
	}
	public Fila carregar(int id) throws IOException{
		return dao.carregaFila(id);
	}
	public void adicionarFila(Fila fila) {
		dao.adicionarFila(fila);
	}
	public void removerFila(Fila id) {
		dao.removerFila(id);
	}
	public void alterarFila(Fila fila) {
		dao.alterarFila(fila);
	}
}
