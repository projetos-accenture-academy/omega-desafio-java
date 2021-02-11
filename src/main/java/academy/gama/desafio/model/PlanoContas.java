package academy.gama.desafio.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import org.hibernate.annotations.GenericGenerator;


import  academy.gama.desafio.enums.TipoTransacao;

/**
 * 
 * @author raul castro
 *
 */

@Entity
@Table(name = "plano_de_contas")
public class PlanoContas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	private String nome_da_movimentacao;
	private String login;
	private TipoTransacao natureza_da_operacao; // aqui entra classificação da conta
	
	/**
	 * getters & setters...
	 * @return
	 */
	
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login=login;
	}
	
	public String getNome_da_movimentacao() {
		return nome_da_movimentacao;
	}
	public void setNome_da_movimentacao(String nome_da_movimentacao) {
		this.nome_da_movimentacao = nome_da_movimentacao;
	}
	public TipoTransacao getNatureza_da_operacao() {
		return natureza_da_operacao;
	}
	public void setNatureza_da_operacao(TipoTransacao natureza_da_operacao) {
		this.natureza_da_operacao = natureza_da_operacao;
	}
	public Long getId() {
		return id;
	}

	
	
	
}
