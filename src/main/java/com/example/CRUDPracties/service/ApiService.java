package com.example.CRUDPracties.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.CRUDPracties.Exception.StudentNotFoundException;
import com.example.CRUDPracties.bean.Student;

public interface ApiService {

	public List<Student> getStudents();
	public List<Student> getStudentsBySorting(String field);
	public Page<Student> getStudentsByPagination(Integer offset,Integer pageSize);
	public Student saveStudent(Student s);
	public Student getStudentById(Integer id) throws StudentNotFoundException;
	public void deleteStudent(Integer id);
	public Student updateStudent(Student s);
	
}
