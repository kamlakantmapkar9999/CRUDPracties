package com.example.CRUDPracties.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.CRUDPracties.bean.Student;
import com.example.CRUDPracties.repository.APIRepository;
import com.example.CRUDPracties.service.ApiService;
import com.example.CRUDPracties.service.ResponseBuilder;
import com.example.bean.ResponesWrapperClass;

@RestController
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@Autowired
	private APIRepository repo;
	
	@Autowired
	private ResponseBuilder builder;
	
	@Autowired
	private RestTemplate rest;
	
	@RequestMapping("/test")
	public String Test() {
		
		Student s = new Student(0,"KamlakantMapkar","36");
		
		  HttpHeaders headers = new HttpHeaders();
	      HttpEntity<Student> entity = new HttpEntity<Student>(s,headers);
	      ResponseEntity<ResponesWrapperClass> entity1 = rest.postForEntity("http://localhost:8080/addStudent", s, ResponesWrapperClass.class);
	      
	     // entity1.getStatusCode()
	      
	      
	      //exchange("http://localhost:8080/addStudent", HttpMethod.POST, entity, ResponesWrapperClass.class);
	    //POST Call
		//rest.postForObject("http://localhost:8080/addStudent",s ,ResponesWrapperClass.class);
		
		//GET Call
		System.out.println(rest.getForObject("http://localhost:8080/getStudentbyId/2", ResponesWrapperClass.class));
		
		return "";
	}
	
	@PostMapping("/addStudent")
	public ResponesWrapperClass saveStudent(@RequestBody Student s) {
		return builder.getPositiveResponse(apiService.saveStudent(s));
	}
	
	@GetMapping( value = "/getAllStudent", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponesWrapperClass saveStudent() {		
		return builder.getPositiveResponse(apiService.getStudents());
	}
	
	@GetMapping("/getAllStudent/{field}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponesWrapperClass saveStudent(@PathVariable("field") String field) {		
		return builder.getPositiveResponse(apiService.getStudentsBySorting(field));
	}
	
	@GetMapping("/searchStudent/{name}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponesWrapperClass searchStudent(@PathVariable("name") String name) {		
		return builder.getPositiveResponse(repo.findAllbyName(name));
	}
	
	@GetMapping("/getAllStudent/{offset}/{pageSize}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponesWrapperClass saveStudent(@PathVariable("offset") Integer offset,@PathVariable("pageSize") Integer pageSize) {		
		return builder.getPositiveResponse(apiService.getStudentsByPagination(offset,pageSize));
	}
	
	@GetMapping("/getStudentbyId/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponesWrapperClass saveStudent(@PathVariable("id") Integer id) {
		return builder.getPositiveResponse(apiService.getStudentById(id));
	}
	
	@DeleteMapping("/deleteStudentbyId/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponesWrapperClass deleteStudent(@PathVariable("id") Integer id) {
		ResponesWrapperClass obj  = new ResponesWrapperClass();
		obj.setCode("200");
		obj.setDescription("Sucessfull");
		obj.setSucessFlag(true);
		apiService.deleteStudent(id);
		return obj;
	}
	
	@PutMapping("/updateStudent")
	@ResponseStatus(HttpStatus.OK)
	public ResponesWrapperClass updateStudent(@RequestBody Student student) {
		return builder.getPositiveResponse(apiService.updateStudent(student));
	}
	
	//filter
	
	//fileupload
	

}
