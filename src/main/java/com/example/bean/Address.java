package com.example.bean;

import com.example.CRUDPracties.bean.Student;

public class Address {
	private Integer addressid;
	private String Hno;
	private String address;
	private Student student;
	
	public Address() {
		super();
	}
	
	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public String getHno() {
		return Hno;
	}

	public void setHno(String hno) {
		Hno = hno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", Hno=" + Hno + ", address=" + address + ", student=" + student
				+ "]";
	}
	
	
}
