package br.com.gerencia.apirest.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNaoEncontrado extends Exception {
	private static final long serialVersionUID = 1L;

	public RecursoNaoEncontrado(String mensagem) {
		super(mensagem);
	}
}