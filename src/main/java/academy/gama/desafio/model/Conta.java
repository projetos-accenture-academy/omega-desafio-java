package academy.gama.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import academy.gama.desafio.enums.TipoConta;
import academy.gama.desafio.exceptions.UsuarioNuloException;
import academy.gama.desafio.utils.Validator;


@Entity
@Table(name = "contas")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable = false,length = 20)
	private String numero;
	
	@Column(nullable = false, length = 50)
	private String descricao;

	@Enumerated(EnumType.STRING)
	private TipoConta tipo;
	
	@Column(nullable = false, scale = 2 ) 
	private Double saldo;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	public Conta() {
	}
	
	/**
	 * Cria uma conta padrão do tipo <b>CC</b> para o usuário informado
	 * @param usuario
	 */
	public Conta(Usuario usuario, String numero) {

		this.saldo = 0.0;
		this.descricao = "Conta Corrente";
		this.tipo = TipoConta.CC;
		this.usuario = usuario;
		this.numero = numero;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}
		
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Double getSaldo() {
		return saldo;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Conta [id=" + id + ", numero=" + numero + ", descricao=" + descricao + ", tipo=" + tipo + ", saldo="
				+ saldo + ", usuario=" + usuario + "]";
	}
	
	
}
