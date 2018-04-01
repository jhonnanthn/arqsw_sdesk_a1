package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
 * @author Jhonnanthn William Carlos Balsas - 816119078
 *
 */
@Entity
@Table(name="Chamado")
public class Chamado implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String ABERTO = "aberto";
	public static final String FECHADO = "fechado";
	
	@Id
	@Column(name="ID_CHAMADO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numero;
	
	@NotNull
	@Column(name="DESCRICAO")
	private String nome;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@NotNull
	@Column(name="DT_ABERTURA")
	private Date dataAbertura;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(name="DT_FECHAMENTO")
	private Date dataFechamento;
	
	@Column(name="STATUS")
	private String status;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_fila")
	private Fila fila;
	
	public Fila getFila() {
		return fila;
	}
	public void setFila(Fila fila) {
		this.fila = fila;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
