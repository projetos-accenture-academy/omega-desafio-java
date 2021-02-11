package academy.gama.desafio.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

<<<<<<< HEAD
/**
 * Tabela de Lançamentos
 * @author Brian
 *
 */
@Entity
@Table(name = "lancamentos")
=======
@Entity
@Table(name = "lancamento")
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
<<<<<<< HEAD
	//TODO: Inserir FK PlanoConta

	//Is null when it's a deposit
	@JoinColumn (name = "id_conta_origem", nullable = true)
	@ManyToOne
	private Conta contaOrigem;
	
  //It's null when it's a withdrawal
=======
	@JoinColumn (name = "id_conta_origem", nullable = false)
	@ManyToOne
	private Conta contaOrigem;
	
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53
	@JoinColumn(name = "id_conta_destino", nullable = true)
	@ManyToOne
	private Conta contaDestino;
	
	@Column
	private LocalDate data;
	
	@Column
	private Double valor;
	
<<<<<<< HEAD

	@Column
	private String descricao;

=======
	//TODO: Inserir PlanoConta
	
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53
	
	
	
	public Lancamento()
	{
		
	}

	public Long getId() {
		return id;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
<<<<<<< HEAD
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
=======
}
>>>>>>> 868dfb8c83602958d5d76cae4623b0f859318e53
