package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

@Service
public class ChamadoService {
	private ChamadoDAO chamadoDAO;
	
	@Autowired
	public ChamadoService(ChamadoDAO chamadoDAO) {
		this.chamadoDAO = chamadoDAO;
	}
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{
		return chamadoDAO.listarChamadosByFila(fila.getId());
	}
	public void adicionarChamado(int id, String nome) throws IOException {
		chamadoDAO.adicionarChamado(id, nome);
	}
}
