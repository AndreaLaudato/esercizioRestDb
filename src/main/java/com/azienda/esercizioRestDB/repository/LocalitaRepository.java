package com.azienda.esercizioRestDB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azienda.esercizioRestDB.model.Localita;
@Repository
public interface LocalitaRepository extends JpaRepository<Localita, Integer>{

	Localita findByNome(String nome);

    List<Localita> findByTemperaturaLessThan(Float temperatura);

    List<Localita> findByTemperaturaGreaterThan(Float temperatura);

}
