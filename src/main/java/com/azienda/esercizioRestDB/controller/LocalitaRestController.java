package com.azienda.esercizioRestDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azienda.esercizioRestDB.model.Localita;
import com.azienda.esercizioRestDB.service.LocalitaService;

@RestController
@RequestMapping(path= "/rest", produces = {"application/json"})
@CrossOrigin(origins = {"*"} )
public class LocalitaRestController {
	
	@Autowired
	private LocalitaService service;
	
	public LocalitaRestController(LocalitaService service) {
        this.service = service;
    }
	
	@GetMapping("/elenco")
	public ResponseEntity<List<Localita>> elenco() {
        List<Localita> elenco = service.getAll();
        return new ResponseEntity<>(elenco, HttpStatus.OK);
    }
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Localita> getById(@PathVariable Integer id) {
        Localita l = service.getById(id);
        if (l != null) {
            return new ResponseEntity<>(l, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@GetMapping("/getByNome/{nome}")
	public ResponseEntity<Localita> getByNome(@PathVariable String nome) {
        Localita l = service.getByNome(nome);
        if (l != null) {
            return new ResponseEntity<>(l, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/getInf/{temperatura}")
	 public ResponseEntity<List<Localita>> getByTemperaturaInferiore(@PathVariable Float temperatura) {
        List<Localita> lista = service.getByTemperaturaInferiore(temperatura);
        if (!lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/getSup/{temperatura}")
	public ResponseEntity<List<Localita>> getByTemperaturaSuperiore(@PathVariable Float temperatura) {
        List<Localita> lista = service.getByTemperaturaSuperiore(temperatura);
        if (!lista.isEmpty()) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PostMapping(path="/inserisci", consumes = {"application/json"})
	public ResponseEntity<Localita> inserisci(@RequestBody Localita l) {
        boolean ok = service.insert(l);
        if (ok) {
            return new ResponseEntity<>(l, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	@PutMapping(path="/aggiornaTotale", consumes = {"application/json"})
	public ResponseEntity<Localita> aggiornaTotale(@RequestBody Localita l) {
        boolean ok = service.update(l);
        if (ok) {
            return new ResponseEntity<>(l, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	@PatchMapping(path="/aggiornaParziale", consumes = {"application/json"})
	public ResponseEntity<Localita> aggiornaParziale(@RequestBody Localita l) {
        boolean ok = service.updatePartial(l);
        if (ok) {
            return new ResponseEntity<>(l, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	@DeleteMapping("/cancella/{id}")
	public ResponseEntity<Void> cancella(@PathVariable Integer id) {
        boolean ok = service.deleteById(id);
        if (ok) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	@DeleteMapping("/cancellaInf/{temperatura}")
	public ResponseEntity<Void> cancellaInf(@PathVariable Float temperatura) {
	    boolean ok = service.deleteByTemperaturaInferiore(temperatura);
	    if (ok) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/cancellaSup/{temperatura}")
	public ResponseEntity<Void> cancellaSup(@PathVariable Float temperatura) {
	    boolean ok = service.deleteByTemperaturaSuperiore(temperatura);
	    if (ok) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
}