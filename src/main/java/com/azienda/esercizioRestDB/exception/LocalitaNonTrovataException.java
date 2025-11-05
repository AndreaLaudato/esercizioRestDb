package com.azienda.esercizioRestDB.exception;

public class LocalitaNonTrovataException extends RuntimeException{
	
	public LocalitaNonTrovataException(String msg) {
		super(msg);
	}
	
	public LocalitaNonTrovataException(String messaggio, Throwable causa) {
        super(messaggio, causa);
    }
	
}