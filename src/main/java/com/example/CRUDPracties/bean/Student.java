package com.example.CRUDPracties.bean;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	private String  studentName;
	private String  studentRollNo;
	//private List<Project> projectList;
	
	public Student() {
		super();
	}

	public Student(Integer studentId, String studentName, String studentRollNo) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentRollNo = studentRollNo;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(String studentRollNo) {
		this.studentRollNo = studentRollNo;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentRollNo=" + studentRollNo
				+ "]";
	}


	/*
	 * public List<Project> getProjectList() { return projectList; }
	 * 
	 * public void setProjectList(List<Project> projectList) { this.projectList =
	 * projectList; }
	 * 
	 * @Override public String toString() { return "Student [studentId=" + studentId
	 * + ", studentName=" + studentName + ", studentRollNo=" + studentRollNo +
	 * ", address=" + address + ", projectList=" + projectList + "]"; }
	 */
	
	
	
	
	
}
