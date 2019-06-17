package br.ufc.crateus.halugar.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.crateus.halugar.model.Casa;
import br.ufc.crateus.halugar.repository.CasaRepository;
import br.ufc.crateus.halugar.service.CasaService;
import br.ufc.crateus.halugar.util.Upload;

@RestController
@RequestMapping(value = "/halugar/casa")
@CrossOrigin
public class CasaController {

	@Autowired
	private CasaRepository casas;

	public CasaService getCasaService() {
		return casaService;
	}

	public void setCasaService(CasaService casaService) {
		this.casaService = casaService;
	}

	@Autowired
	private CasaService casaService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Casa getCasaById(Integer id) {
		return casaService.getCasaById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Casa>> getCasas() {
		return new ResponseEntity<List<Casa>>((List<Casa>) casaService.getCasas(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Casa> addCasa(String endereco, Integer numero, String cep, String bairro, String informacoes,
			String preco, Integer vagas, MultipartFile image) {

		Casa novo = new Casa(null, endereco, numero, cep, bairro, informacoes, preco, vagas);

		Casa aux = casas.saveAndFlush(novo);
		try {
			Upload.uploadFile(image.getInputStream(), aux.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Casa>((Casa) novo, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Casa editCasa(Casa casa) {
		return casaService.editCasa(casa);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteCasa(Casa casa) {
		casaService.deleteCasa(casa);
	}

	public void setCasas(CasaRepository casas) {
		this.casas = casas;
	}
}
