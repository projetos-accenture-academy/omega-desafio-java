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

@Entity
@Table(name = "lancamento")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn (name = "id_conta_origem", nullable = false)
	@ManyToOne
	private Conta contaOrigem;
	
	@JoinColumn(name = "id_conta_destino", nullable = true)
	@ManyToOne
	private Conta contaDestino;
	
	@Column
	private LocalDate data;
	
	@Column
	private Double valor;
	
	//TODO: Inserir PlanoConta
	
	
	
	
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
}