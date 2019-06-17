package br.ufc.crateus.halugar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.crateus.halugar.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("from Usuario where login = ?1")
	Usuario findByLogin(String nome);
}
