package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

public class ChamadoDAO {
	
	public int criarChamado(Chamado chamado) {
		Date dataAbertura = new Date(chamado.getDataAbertura().getTime());
		return 0;
	}

	public ArrayList<Chamado> listarChamadosByFila(int idFila) throws IOException {
		String query = 
				"SELECT" + 
				"	C.ID_CHAMADO 						AS numero," + 
				"    C.DESCRICAO 	 					AS nome," + 
				"    C.STATUS			 				AS status," + 
				"    C.DT_ABERTURA						AS dataAbertura," + 
				"    C.DT_FECHAMENTO						AS dataFechamento," + 
				"    F.ID_FILA							AS ID_FILA," + 
				"    F.NM_FILA							AS NOME_FILA" + 
				" FROM" + 
				"	CHAMADO C, FILA F" + 
				"    WHERE C.ID_FILA = F.ID_FILA" + 
				"    AND C.ID_FILA = ?";
		ArrayList<Chamado> lista = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);){
				pst.setInt(1, idFila);

			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Chamado chamado = new Chamado();
					chamado.setNumero(rs.getInt("numero"));
					chamado.setNome(rs.getString("nome"));
					chamado.setStatus(rs.getString("status"));
					chamado.setDataAbertura(rs.getDate("dataAbertura"));
					chamado.setDataFechamento(rs.getDate("dataFechamento"));
					
					Fila fila = new Fila();
					fila.setId(rs.getInt("ID_FILA"));
					fila.setNome(rs.getString("NOME_FILA"));
					chamado.setFila(fila);
					lista.add(chamado);
				}
			} catch (SQLException e) {
				throw new IOException(e);
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}
}
