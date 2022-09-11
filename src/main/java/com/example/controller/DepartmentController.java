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
import com.example.dto.DepartmentDto;
import com.example.models.Department;
import com.example.service.DepartmentService;

/**
 * @author Sanyuja Kharat
 * Department Controller
 */
@RestController
public class DepartmentController {

	@Autowired
	DepartmentService deptservice;

	@PostMapping("/savedept")
	public ResponseEntity<?> insertdepartment(@RequestBody @Valid DepartmentDto dto) {
		Department dept = deptservice.deptsave(dto);
		return ResponseEntity.ok(new CustomResponse(202,"Record inserted successfully",dept));

	}

	@PutMapping("/updatedept")
	public ResponseEntity<?> updatedepartment(@RequestBody @Valid DepartmentDto dto) throws CustomException {
		Department dept = deptservice.updatedept(dto);
		return ResponseEntity.ok(new CustomResponse(202,"Record inserted successfully",dept));

	}

	@GetMapping("/getalldept")
	public ResponseEntity<?> getdepts() {
		List<Department> dept = deptservice.getdept();
		return ResponseEntity.ok(new CustomResponse(202,"All departments",dept));
	}

}
