package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

@Repository
public class UsuarioDAO {
	private Connection conn;

	@Autowired
	public UsuarioDAO(DataSource dataSource) throws IOException{
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

	public Usuario buscaUsuario(String nome, String password) throws IOException {
		String query = "SELECT USERNAME AS NOME, PASSWORD FROM USUARIO WHERE USERNAME = ? AND PASSWORD = ?";
		Usuario usuario = new Usuario();
		try (PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setString(1, nome);
			pst.setString(2, password);

			try (ResultSet rs = pst.executeQuery();) {
				while(rs.next()) {
					usuario.setNome(rs.getString("NOME"));
					usuario.setPassword(rs.getString("PASSWORD"));
				}
			} catch (SQLException e) {
				throw new IOException(e);
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return usuario;
	}

}
