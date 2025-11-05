package com.azienda.esercizioRestDB.exception;

public class TemperaturaException extends RuntimeException{

	public TemperaturaException(String msg) {
		super(msg);
	}
	
	public TemperaturaException(String messaggio, Throwable causa) {
        super(messaggio, causa);
    }
	
}
