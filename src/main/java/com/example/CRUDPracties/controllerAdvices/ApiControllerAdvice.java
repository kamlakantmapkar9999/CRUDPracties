package com.example.CRUDPracties.controllerAdvices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.CRUDPracties.Exception.StudentNotFoundException;
import com.example.CRUDPracties.Exception.StudentsNotFoundException;
import com.example.CRUDPracties.service.ResponseBuilder;
import com.example.bean.ResponesWrapperClass;

@RestControllerAdvice
public class ApiControllerAdvice {
	
	@Autowired
	private ResponseBuilder builder;
	
	@ExceptionHandler(value = StudentNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponesWrapperClass handleStudentNotFoundException(StudentNotFoundException exception) {
		return builder.getNegativeResponse(exception.getMessage());	
	}
	
	
	@ExceptionHandler(value = StudentsNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponesWrapperClass handleStudentsNotFoundException(StudentsNotFoundException exception) {
		return builder.getNegativeResponse("Student Not found");	
	}
	
	
	 @ExceptionHandler(value = RuntimeException.class)
	 
	 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) public ResponesWrapperClass
	 handleStudentNotFoundException(RuntimeException exception) {
		 return builder.getNegativeResponse("Unable to process the request"); 
		 }
	 
	
	
	

}
