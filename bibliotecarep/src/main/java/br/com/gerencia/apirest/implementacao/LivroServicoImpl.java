package br.com.gerencia.apirest.implementacao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.gerencia.apirest.excecao.RecursoNaoEncontrado;
import br.com.gerencia.apirest.modelo.Livro;
import br.com.gerencia.apirest.repositorio.LivroRepositorio;
import br.com.gerencia.apirest.servico.ILivroServico;
 
@Service
public class LivroServicoImpl implements ILivroServico {
 
	@Autowired
	private LivroRepositorio repositorio;
 
	@Override
	public Livro salvarLivro(Livro livro) {
		return repositorio.save(livro);
	}
 
	@Override
	public List<Livro> buscarTodosLivros() {
		return repositorio.findAll();
	}
 
	@Override
	public Livro bucarLivroPorId(Long id) {
		Optional<Livro> opcional = repositorio.findById(id);
		if (opcional.isPresent()) {
			return opcional.get();
		} else {
			new RecursoNaoEncontrado("Livro com id: " + id + " não encontrado.");
		}
		return opcional.get();
	}
	
	@Override
	public void deletarLivroPorId(Long id) {
		repositorio.delete(bucarLivroPorId(id));
	}
 
	@Override
	public void atualizarLivro(Livro invoice) {
		repositorio.save(invoice);
	}
}