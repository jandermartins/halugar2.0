package br.ufc.crateus.halugar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.halugar.model.Casa;
import br.ufc.crateus.halugar.repository.CasaRepository;

@Service
public class CasaService {
	
	@Autowired
	private CasaRepository casaRepository;
	
	public Casa getCasaById(Integer id) {
		return casaRepository.findById(id).get();
	}
	
	public List<Casa> getCasas() {
		return casaRepository.findAll();
	}
	
	public Casa addCasa(Casa casa) {
		return casaRepository.saveAndFlush(casa);
	}
	
	public Casa editCasa(Casa casa) {
		return casaRepository.saveAndFlush(casa);
	}
	
	public void deleteCasa(Casa casa) {
		casaRepository.delete(casa);
	}	
}
