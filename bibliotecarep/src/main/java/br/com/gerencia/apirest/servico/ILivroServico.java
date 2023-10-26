package br.com.gerencia.apirest.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gerencia.apirest.modelo.Livro;

@Service
public interface ILivroServico {

	public Livro salvarLivro(Livro livro);

	public List<Livro> buscarTodosLivros();

	public Livro bucarLivroPorId(Long id);

	public void deletarLivroPorId(Long id);

	public void atualizarLivro(Livro livro);

}