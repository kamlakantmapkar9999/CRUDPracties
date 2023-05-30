package com.example.CRUDPracties.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.CRUDPracties.Exception.StudentNotFoundException;
import com.example.CRUDPracties.Exception.StudentsNotFoundException;
import com.example.CRUDPracties.bean.Student;
import com.example.CRUDPracties.repository.APIRepository;

@Service
public class ApiServiceImpl implements ApiService{
	
	@Autowired
	private APIRepository aPIRepository;

	@Override
	public List<Student> getStudents() {
		List<Student> list = aPIRepository.findAll();
		if(list == null || list.isEmpty()) {
			throw new StudentsNotFoundException();
		}
		return list;
		
	}

	@Override
	public Student getStudentById(Integer id) throws StudentNotFoundException {
		if(!aPIRepository.existsById(id)) {
			throw new StudentNotFoundException("Student not found in database");
		}
		Student s = aPIRepository.getStudentByStudentId(id);
		return s;
	}

	@Override
	public void deleteStudent(Integer id) {
		aPIRepository.deleteById(id);
	}

	@Override
	public Student updateStudent(Student s) {
		Student save = aPIRepository.getStudentByStudentId(s.getStudentId());
		save.setStudentName(s.getStudentName());
		save.setStudentRollNo(s.getStudentRollNo());
		return aPIRepository.save(save);
	}

	@Override
	public Student saveStudent(Student s) {
		if(aPIRepository.existsById(s.getStudentId())) {
			throw new StudentNotFoundException("Student already present in database");
		}
		return aPIRepository.save(s);
	}

	@Override
	public List<Student> getStudentsBySorting(String field) {
		List<Student> list = aPIRepository.findAll(Sort.by(Sort.Direction.DESC,field));
		if(list == null || list.isEmpty()) {
			throw new StudentsNotFoundException();
		}
		return list;
		
	}

	@Override
	public Page<Student> getStudentsByPagination(Integer offset, Integer pageSize) {
		Page<Student> list = aPIRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.Direction.DESC, "studentId"));
		/*
		 * if(list == null || list.isEmpty()) { throw new StudentsNotFoundException(); }
		 */
		return list;
		
	}

}
