package com.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.model.Contato;
import com.agenda.service.ContatoService;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Contato> findAll() {
		return this.contatoService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Contato findOne(@PathVariable("id") Integer idContato) {
		return this.contatoService.findOne(idContato);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Contato create(@RequestBody Contato contato) {
		return this.contatoService.create(contato);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") Integer idContato, @RequestBody Contato contato) {
		contato.setId(idContato);
		this.contatoService.update(contato);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Integer idContato) {
		this.contatoService.delete(idContato);
	}

}
