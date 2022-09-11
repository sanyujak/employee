package com.example.dto;

import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author Sanyuja Kharat
 *
 */
public class SkillsDto {

	Optional<Integer> id;
	
	@NotNull
	@Size(max=10,message="Characeters should not be greater than 10")
	String skillname;

	public Optional<Integer> getId() {
		return id;
	}

	public void setId(Optional<Integer> id) {
		this.id = id;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	@Override
	public String toString() {
		return "SkillsDto [id=" + id + ", skillname=" + skillname + "]";
	}

}
