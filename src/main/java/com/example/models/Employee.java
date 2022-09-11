package com.example.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author Sanyuja Kharat
 * 
 *         Employee entity
 *
 */
@Entity
@Table(name = "Employee")
public class Employee extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	String emp_name;

	double salary;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date joining_date;

	@Column(nullable = false, unique = true)
	String emailid;

	@Column(columnDefinition = "TINYINT(1)")
	boolean active;

	@ManyToOne
	@JoinColumn(name = "Department_id")
	private Department dept;

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "employee_skills", joinColumns = { @JoinColumn(name = "skills_id") }, inverseJoinColumns = {
			@JoinColumn(name = "employee_id") })
	List<Skills> skills;

	public Department getDept() {
		return dept;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Employee() {

	}

	public Employee(int id, String emp_name, double salary, Date joining_date) {

		this.id = id;
		this.emp_name = emp_name;
		this.salary = salary;
		this.joining_date = joining_date;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", emp_name=" + emp_name + ", salary=" + salary + ", joining_date=" + joining_date
				+ "]";
	}

}
