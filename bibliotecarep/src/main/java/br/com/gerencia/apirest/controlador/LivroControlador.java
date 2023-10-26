package br.com.gerencia.apirest.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.gerencia.apirest.excecao.RecursoNaoEncontrado;
import br.com.gerencia.apirest.modelo.Livro;
import br.com.gerencia.apirest.servico.ILivroServico;

@Controller
@RequestMapping("/livro")
public class LivroControlador {

	@Autowired
	private ILivroServico service;

	@GetMapping("/")
	public String exibirPaginaInicial() {
		return "paginaInicio";
	}

	@GetMapping("/adicionar")
	public String exibirFormularioAdicao() {
		return "adicionarLivro";
	}

	@PostMapping("/salvar")
	public String salvarLivro(@ModelAttribute Livro livro, Model modelo) {
		service.salvarLivro(livro);
		Long id = service.salvarLivro(livro).getId();
		String mensagem = "Livro com id: '" + id + "' salva com sucesso!";
		modelo.addAttribute("message", mensagem);
		return "adicionarLivro";
	}

	@GetMapping("/listar")
	public String buscarTodosLivros(@RequestParam(value = "message", required = false) String mensagem, Model modelo) {
		List<Livro> livros = service.buscarTodosLivros();
		modelo.addAttribute("listagem", livros);
		modelo.addAttribute("message", mensagem);
		return "listarLivros";
	}

	@GetMapping("/editar")
	public String exibirFormularioEdicao(Model modelo, RedirectAttributes atributos, @RequestParam Long id) {
		String pagina = null;
		try {
			Livro livro = service.bucarLivroPorId(id);
			modelo.addAttribute("livro", livro);
			pagina = "editarLivro";
		} catch (Exception e) {
			e.printStackTrace();
			atributos.addAttribute("message", e.getMessage());
			new RecursoNaoEncontrado(e.getMessage());
			pagina = "redirect:listar";
		}
		return pagina;
	}

	@PostMapping("/atualizar")
	public String atualizarLivro(@ModelAttribute Livro livro, RedirectAttributes atributos) {
		service.atualizarLivro(livro);
		Long id = livro.getId();
		atributos.addAttribute("message", "Fatura com id: '" + id + "' atualizada com sucesso!");
		return "redirect:listar";
	}

	@GetMapping("/deletar")
	public String deletarLivro(@RequestParam Long id, RedirectAttributes atributos) {
		try {
			service.deletarLivroPorId(id);
			atributos.addAttribute("message", "Fatura com id: '" + id + "' excluída com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			atributos.addAttribute("message", e.getMessage());
			new RecursoNaoEncontrado(e.getMessage());
		}
		return "redirect:listar";
	}
}