package br.ufc.crateus.halugar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.halugar.model.Anuncio;
import br.ufc.crateus.halugar.model.Casa;
import br.ufc.crateus.halugar.model.Usuario;
import br.ufc.crateus.halugar.repository.AnuncioRepository;

@Service
public class AnuncioService {
	
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	public Anuncio getAnuncioById(Integer id) {
		return anuncioRepository.findById(id).get();
	}
	
	public List<Anuncio> getAnuncios() {
		return anuncioRepository.findAll();
	}
	
	public Anuncio addAnuncio(Anuncio anuncio) {
		return anuncioRepository.saveAndFlush(anuncio);
	}
	
	public Anuncio editAnuncio(Anuncio anuncio) {
		return anuncioRepository.saveAndFlush(anuncio);
	}
	
	public void deleteAnuncio(Anuncio anuncio) {
		anuncioRepository.delete(anuncio);
	}
}
