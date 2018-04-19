package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author jhonnanthn william carlos balsas
 * 816119078
 *
 */
@Entity
@Table(name="Fila")
public class Fila implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String DATE_PATTERN = "dd-MM-yyyy'T'HH:mm:ss'Z'Z";

	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	@Column(name="ID_FILA")
	private int id;
	
	@Column(name="NM_FILA")
	private String nome;
	
	@NotNull
	@Size(max=256)
	@Column(name="caminho_figura")
	private String figura;
	
	@JsonFormat(pattern=Fila.DATE_PATTERN)
	@Null
	@Column(name="dt_atual")
	private Date dataAtualizacao;
	
	public String getFigura() {
		return figura;
	}
	public void setFigura(String figura) {
		this.figura = figura;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Fila [id=" + id + ", nome=" + nome + "]";
	}
}
