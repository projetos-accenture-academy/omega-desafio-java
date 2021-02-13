package academy.gama.desafio.exceptions;

public class UsuarioNuloException extends Exception {

	public UsuarioNuloException() {
		super("O usuário da conta não pode ser nulo.");
	}


}
