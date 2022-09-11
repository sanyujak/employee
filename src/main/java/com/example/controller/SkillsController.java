package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.CustomException;
import com.example.Response.CustomResponse;
import com.example.dto.SkillsDto;
import com.example.models.Skills;
import com.example.service.SkillsService;


/**
 * @author Sanyuja Kharat
 * SkillsController
 */
@RestController
public class SkillsController {
			
		@Autowired
		SkillsService skillsservice;
		
		@PostMapping("/saveskills")
		public ResponseEntity<?>insertskills(@RequestBody @Valid SkillsDto skilldto)
		{
			Skills skill=skillsservice.skillsinsert(skilldto);
			return ResponseEntity.ok(new CustomResponse(202,"Inserted Successfully",skill));
		}
		
		@PutMapping("/updateskills")
		public ResponseEntity<?> updateskills(@RequestBody @Valid SkillsDto skilldto) throws CustomException
		{
			Skills skills=skillsservice.updateskills(skilldto);
			return ResponseEntity.ok(new CustomResponse(202,"Updated Successfully",skills));
		}
		
		@GetMapping("/getskills")
		public ResponseEntity<?> getallskills(){
			List<Skills>skill=skillsservice.getskills();
			//return new ResponseEntity<List<Skills>>(skill,HttpStatus.OK);
			return ResponseEntity.ok(new CustomResponse(202,"Retrieving all skills",skill));
			
		}

}
