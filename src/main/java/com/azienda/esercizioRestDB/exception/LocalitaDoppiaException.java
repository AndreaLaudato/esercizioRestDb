package com.azienda.esercizioRestDB.exception;

public class LocalitaDoppiaException extends RuntimeException{
	
	public LocalitaDoppiaException(String msg) {
		super(msg);
	}
	
	public LocalitaDoppiaException(String messaggio, Throwable causa) {
        super(messaggio, causa);
    }
	
}
