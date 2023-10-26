package br.com.gerencia.apirest.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// Tabela a ser criada no banco de dados
@Table(name = "livros")
public class Livro {
// Atributos da classe
	private long id;
	private Integer cdLivro;
	private String titulo;
	private String autor;
	private Integer isbn;
	private String editora;

	public Livro() {
	}

	public Livro(Integer cdLivro, String titulo, String autor, Integer isbn, String editora) {
		this.cdLivro = cdLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.editora = editora;
	}

// Campo Id que será gerado automaticamente na tabela do banco de dados
// (autoincremento)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "cdLivro", nullable = false)
	public Integer getCdLivro() {
		return cdLivro;
	}

	public void setCdLivro(Integer cdLivro) {
		this.cdLivro = cdLivro;
	}
	@Column(name = "titulo", nullable = false)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "autor", nullable = false)
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Column(name = "isbn", nullable = false)
	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	@Column(name = "editora", nullable = false)
	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

//Concatena todos os campos e converte em texto
	@Override
	public String toString() {
		return "Empregado [id=" + id + ", cdLivro=" + cdLivro + ", titulo=" + titulo + 
			   ", autor=" + autor + ", isbn=" + isbn + ", editora=" + editora + "]";
	}
}