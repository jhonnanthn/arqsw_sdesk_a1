package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

public class ChamadoService {
	ChamadoDAO chamadoDAO = new ChamadoDAO();
	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{
		
		return chamadoDAO.listarChamadosByFila(fila.getId());
	}
}
