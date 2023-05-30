package com.example.CRUDPracties.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CRUDPracties.bean.Student;
import com.example.bean.ResponesWrapperClass;

@Service
public class ResponseBuilder<T> {
	

	public ResponesWrapperClass getPositiveResponse(T student) {
		ResponesWrapperClass obj  = new ResponesWrapperClass();
		obj.setCode("200");
		obj.setDescription("Sucessfull");
		obj.setSucessFlag(true);
		obj.setS(student);
		return obj;
	}
	
	public ResponesWrapperClass getNegativeResponse(String description) {
		ResponesWrapperClass obj  = new ResponesWrapperClass();
		obj.setCode("400");
		obj.setDescription(description);
		obj.setSucessFlag(true);
		return obj;
	}
	


}
