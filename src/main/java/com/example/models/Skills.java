package com.example.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Sanyuja Kharat 
 *         Skills entity
 */
@Entity
@Table(name = "Skills")
public class Skills  extends BaseEntity{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(nullable = false, unique = true)
	String skillname;
	
	String skill;
	
	String fieldcheck;

	@ManyToMany(mappedBy = "skills")
	List<Employee> employees;

	public Skills() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Skills [id=" + id + ", skillname=" + skillname + ", employees=" + employees + "]";
	}

}
