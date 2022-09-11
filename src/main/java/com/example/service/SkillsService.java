package com.example.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.CustomException;
import com.example.dto.SkillsDto;
import com.example.models.Skills;
import com.example.repository.SkillsRepository;


/**
 * @author Sanyuja Kharat
 *         Skills Service
 */
@Service
public class SkillsService {

	@Autowired
	SkillsRepository skillsrepo;

	public Skills skillsinsert(SkillsDto skillsdto) {

		Skills skills = new Skills();
		String skillname = skillsdto.getSkillname();
		skills.setSkillname(skillname);
		return skillsrepo.save(skills);

	}

	public Skills updateskills(SkillsDto skillsdto) throws CustomException {

		Optional<Integer> id = skillsdto.getId();
		if (!id.isPresent())
			throw new CustomException("Skill id is not present");
		Integer id1 = id.get();
		Optional<Skills> skills = skillsrepo.findById(id1);

		Skills skill = skills.get();
		String skillsname = skillsdto.getSkillname();
		skill.setSkillname(skillsname);
		return skillsrepo.save(skill);

	}

	public List<Skills> getskills() {

		//get all skills
		List<Skills> skill = skillsrepo.findAll();
		//sort names by ascending order
		List<Skills> sorted = skill.stream().sorted(Comparator.comparing(Skills::getSkillname)).collect(Collectors.toList());

		return sorted;

	}

}
