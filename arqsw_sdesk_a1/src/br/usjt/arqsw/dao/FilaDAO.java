package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Fila;

public class FilaDAO {

	public ArrayList<Fila> listarFilas() throws IOException {
		String query = "select id_fila, nm_fila from fila";
		ArrayList<Fila> lista = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Fila fila = new Fila();
				fila.setId(rs.getInt("id_fila"));
				fila.setNome(rs.getString("nm_fila"));
				lista.add(fila);
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}

	public Fila carregaFila(int id) throws IOException {
		String query = "select id_fila, nm_fila from fila where id_fila = ?";
		Fila fila = new Fila();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					fila.setId(rs.getInt("id_fila"));
					fila.setNome(rs.getString("nm_fila"));
				}
			} catch (SQLException e) {
				throw new IOException(e);
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return fila;
	}

}
