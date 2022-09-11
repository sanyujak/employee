package com.example.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Sanyuja
 * 
 *         Department Entity
 *
 */
@Entity
@Table(name = "Department")
public class Department extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
	String dept_name;

	@OneToMany
	List<Employee> emp;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Department [dept_name=" + dept_name + ", emp=" + emp + "]";
	}

	

}
