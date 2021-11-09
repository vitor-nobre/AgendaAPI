package com.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agenda.model.Contato;
import com.agenda.repository.IContatoRepository;

@Service
@Transactional
public class ContatoService {

	@Autowired
	private IContatoRepository contatoRepository;

	@Transactional
	public Contato create(Contato contato) {
		if (contato.getNome() != null && (contato.getTelefone() != null || contato.getEmail() != null)) {
			return this.contatoRepository.save(contato);
		}
		return null;
	}

	@Transactional
	public void update(Contato contato) {
		this.contatoRepository.save(contato);
	}

	public void delete(Integer idContato) {
		this.contatoRepository.deleteById(idContato);
	}

	@Transactional
	public List<Contato> findAll() {
		return this.contatoRepository.findAll();
	}

	@Transactional
	public Contato findOne(Integer idContato) {

		Optional<Contato> result = this.contatoRepository.findById(idContato);

		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}
}
