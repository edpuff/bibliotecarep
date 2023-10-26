package br.com.gerencia.apirest.excecao;

import java.util.Date;

public class DetalhamentoErro {
	private Date data;
	private String mensagem;
	private String detalhes;

	public DetalhamentoErro(Date data, String mensagem, String detalhes) {
		super();
		this.data = data;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

	public Date getData() {
		return data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDetalhes() {
		return detalhes;
	}
}