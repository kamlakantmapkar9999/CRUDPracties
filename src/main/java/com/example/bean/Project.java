package com.example.bean;

import com.example.CRUDPracties.bean.Student;

public class Project {
	private Integer projectid;
	private String projectName;
	private Student student;
	
	public Project() {
		super();
	}

	public Integer getProjectid() {
		return projectid;
	}

	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Project [projectid=" + projectid + ", projectName=" + projectName + ", student=" + student + "]";
	}
	
}
