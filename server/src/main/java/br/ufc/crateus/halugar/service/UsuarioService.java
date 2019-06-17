package br.ufc.crateus.halugar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.halugar.model.Usuario;
import br.ufc.crateus.halugar.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario getUsuarioById(Integer id) {
		return usuarioRepository.findById(id).get();		
	}
	
	public Usuario getUsuarioByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}

	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}

	public Usuario editUsuario(Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}

	public void deleteUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
}
