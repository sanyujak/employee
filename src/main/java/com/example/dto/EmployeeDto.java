package com.example.dto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author Sanyuja Kharat
 *
 */
public class EmployeeDto {

	Optional<Integer> id;
	
    @NotNull
    @Size(max=20,message="Characters should not be greater than 20")
	String emp_name;
    
    @NotNull
    @Min(value=2000,message="Salary should not be less than 2000")
	double salary;
    
	Date joining_date;
	
	@NotNull
	String email_id;
	
	boolean active;
	
	@NotNull
	int department_id;
	
	List<Integer> skillid;

	public EmployeeDto()
	{
		
	}
	public void setSkillid(List<Integer> skillid) {
		this.skillid = skillid;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Optional<Integer> getId() {
		return id;
	}

	public void setId(Optional<Integer> id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public List<Integer> getSkillid() {
		return skillid;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", emp_name=" + emp_name + ", salary=" + salary + ", joining_date="
				+ joining_date + ", email_id=" + email_id + ", active=" + active + ", department_id=" + department_id
				+ ", skillid=" + skillid + "]";
	}

}
