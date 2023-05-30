package com.example.bean;

import com.example.CRUDPracties.bean.Student;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponesWrapperClass<T> {
	private boolean sucessFlag;
	private String code;
	private String description;
	private T s;
	
	public ResponesWrapperClass(){
		
	}
	
	public boolean isSucessFlag() {
		return sucessFlag;
	}
	public void setSucessFlag(boolean sucessFlag) {
		this.sucessFlag = sucessFlag;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public T getS() {
		return s;
	}
	public void setS(T s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "ResponesWrapperClass [sucessFlag=" + sucessFlag + ", code=" + code + ", description=" + description
				+ ", s=" + s + "]";
	}
	
	
	
}
