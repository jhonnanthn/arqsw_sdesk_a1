package br.usjt.arqsw.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.UsuarioDAO;
import br.usjt.arqsw.entity.Usuario;

@Service
public class UsuarioService {
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public UsuarioService(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	public Usuario buscaUsuario(Usuario usuario) throws IOException {
		return usuarioDAO.buscaUsuario(usuario);
	}

}
