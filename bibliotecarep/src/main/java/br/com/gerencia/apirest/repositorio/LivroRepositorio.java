package br.com.gerencia.apirest.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.gerencia.apirest.modelo.Livro;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {
}
