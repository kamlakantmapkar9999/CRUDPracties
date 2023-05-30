package com.example.CRUDPracties.Exception;

public class StudentsNotFoundException extends RuntimeException{
	public StudentsNotFoundException(String message) {
		super(message);
	}
	
	public StudentsNotFoundException() {
		
	}
}
