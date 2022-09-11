package com.example.dto;

import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author Sanyuja Kharat
 *
 */
public class DepartmentDto {

	Optional<Integer> id;
	
	@NotNull
	@Size(max=20,message="Characters should not be greater than 20")
	String dept_name;

	public Optional<Integer> getId() {
		return id;
	}

	public void setId(Optional<Integer> id) {
		this.id = id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	@Override
	public String toString() {
		return "DepartmentDto [id=" + id + ", dept_name=" + dept_name + "]";
	}

}
