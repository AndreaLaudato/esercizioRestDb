package com.azienda.esercizioRestDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azienda.esercizioRestDB.model.Localita;
import com.azienda.esercizioRestDB.repository.LocalitaRepository;

@Service
@Transactional
public class LocalitaService {

	@Autowired
	private LocalitaRepository repository;

	public LocalitaService(LocalitaRepository repository) {
		this.repository = repository;
	}
	
	public LocalitaService() {
		this.repository = null;
	}

	public List<Localita> getAll() {
		return repository.findAll();
	}

	public Localita getById(Integer id) {
		Optional<Localita> opt = repository.findById(id);
		return opt.orElse(null);
	}

	public Localita getByNome(String nome) {
		return repository.findByNome(nome);
	}

	public List<Localita> getByTemperaturaInferiore(Float temperatura) {
		return repository.findByTemperaturaLessThan(temperatura);
	}

	public List<Localita> getByTemperaturaSuperiore(Float temperatura) {
		return repository.findByTemperaturaGreaterThan(temperatura);
	}

	public boolean insert(Localita l) {
		if (l.getNome() == null || l.getNome().isEmpty() || l.getTemperatura() == null)
			return false;
		if (repository.findByNome(l.getNome()) != null)
			return false;

		if (l.getTemperatura() < -80.0f || l.getTemperatura() > 80.0f)
			return false;
		repository.save(l);
		return true;
	}

	public boolean update(Localita l) {

		if (l.getId() == null)
			return false;

		Optional<Localita> existingOpt = repository.findById(l.getId());
		if (existingOpt.isEmpty())
			return false;

		repository.save(l);
		return true;
	}

	public boolean deleteById(Integer id) {
		if (!repository.existsById(id))
			return false;

		repository.deleteById(id);
		return true;
	}

	public boolean updatePartial(Localita l) {
		if (l.getId() == null)
			return false;

		Optional<Localita> existingOpt = repository.findById(l.getId());
		if (existingOpt.isEmpty())
			return false;

		Localita existing = existingOpt.get();

		if (l.getNome() != null && !l.getNome().isEmpty()) {
			existing.setNome(l.getNome());
		}

		if (l.getTemperatura() != null) {
			if (l.getTemperatura() < -80.0f || l.getTemperatura() > 80.0f)
				return false;
			existing.setTemperatura(l.getTemperatura());
		}

		repository.save(existing);
		return true;
	}

	public boolean deleteByTemperaturaInferiore(Float temperatura) {
		List<Localita> list = repository.findByTemperaturaLessThan(temperatura);
		if (list.isEmpty()) return false;
		repository.deleteAll(list);
		return true;
	}

	public boolean deleteByTemperaturaSuperiore(Float temperatura) {
		List<Localita> list = repository.findByTemperaturaGreaterThan(temperatura);
		if (list.isEmpty()) return false;
		repository.deleteAll(list);
		return true;
	}
// fare i collegamenti con @autowired tra controller e service e service e repository
// aggiungere try catch nel controller, codice debole!	
// metodi con true e false non vanno bene, usare le exception custom
// aggiungere le exception
// aggiungere costruttore vuoto	in service
}
