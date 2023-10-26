package br.com.gerencia.apirest.excecao;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExcecaoGeral {
	@ExceptionHandler(RecursoNaoEncontrado.class)
	public ResponseEntity<?> resourceNotFoundException(RecursoNaoEncontrado excecao, WebRequest requisicao) {
		DetalhamentoErro detalheErro = new DetalhamentoErro(new Date(), excecao.getMessage(),
				requisicao.getDescription(false));
		return new ResponseEntity<>(detalheErro, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception excecao, WebRequest requisicao) {
		DetalhamentoErro detalheErro = new DetalhamentoErro(new Date(), excecao.getMessage(),
				requisicao.getDescription(false));
		return new ResponseEntity<>(detalheErro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}