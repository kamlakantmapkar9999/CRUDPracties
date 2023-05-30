package com.example.CRUDPracties.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CRUDPracties.bean.Student;

@Repository
public interface APIRepository extends JpaRepository<Student, Integer>{
	
	public Student getStudentByStudentId(Integer id);
	
	@Query("Select s from Student s where s.studentName like %?1%")
	public List<Student> findAllbyName(String name);

}
