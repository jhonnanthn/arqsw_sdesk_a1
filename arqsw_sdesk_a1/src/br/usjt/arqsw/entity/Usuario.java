package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author jhonnanthn.balsas
 *
 */
@Entity
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message="Não é permitido campo nulo.")
	@Min(value=1, message="Quantidade de caracteres inválida.")
	@Column(name="USERNAME")
	@Id
	private String nome;
	@NotNull
	@Column(name="PASSWORD")
	private String password;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", password=" + password + "]";
	}
}
