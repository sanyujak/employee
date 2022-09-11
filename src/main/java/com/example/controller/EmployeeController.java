package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.CustomException;
import com.example.Response.CustomResponse;
import com.example.dto.EmployeeDto;
import com.example.models.Employee;
import com.example.service.EmployeeService;
import com.example.utlis.EmployeeUtlilClass;

/**
 * @author Sanyuja Kharat EmployeeController
 */
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@Autowired
	EmployeeUtlilClass utilclass;

	@PostMapping("/saveemp")
	public ResponseEntity<?> saveemployee(@RequestBody @Valid EmployeeDto emp1) throws CustomException {
		Employee emp = service.empinsert(emp1);
		return ResponseEntity.ok(new CustomResponse(200, "Inserted successfully", emp));

	}

	@GetMapping("/employeesal/{deptname}")
	public ResponseEntity<?> getsalary(@PathVariable("deptname") String dept_name) {
		List<Employee> emp = service.empsalary(dept_name);
		return ResponseEntity.ok(new CustomResponse(200, "List Of employees accordingto salary", emp));

	}

	@GetMapping("/employee/date/{deptname}")
	public ResponseEntity<?> getbydate(@PathVariable("deptname") String dept_name) {
		List<Employee> emp = service.empdate(dept_name);
		return ResponseEntity.ok(new CustomResponse(200, "Fetch by date", emp));

	}

	@PutMapping("/updateemp")
	public ResponseEntity<?> updateemployee(@RequestBody @Valid EmployeeDto emp1) throws CustomException {
		Employee emp = service.empupdate(emp1);
		return ResponseEntity.ok(new CustomResponse(200, "Updated successfully", emp));
	}

	@GetMapping("/getemp/{deptname}")
	public ResponseEntity<?> getemployees(@PathVariable("deptname") String dept_name) {

		List<Employee> emp = service.listemp(dept_name);
		String dd = utilclass.getmessage("emp.dd", new String[] { dept_name });
		return ResponseEntity.ok(new CustomResponse(200, dd, emp));
	}

	@DeleteMapping("/employee/delete")
	public ResponseEntity<?> deleteemp(@RequestParam("id") int id) throws CustomException {
		Employee emp = service.empdelete(id);
		return ResponseEntity.ok(new CustomResponse(202, "Deletion operation performed successfully", emp));
	}

	@GetMapping("/getemployees")
	public ResponseEntity<?> getallemployees() {
		List<Employee> listOfEmployees = service.getallemployees();
		String aa = utilclass.getmessage("emp.get", new Object[] { "abc", 1.2f, 563.98, (byte) 1 });
		return ResponseEntity.ok(new CustomResponse(200, aa, listOfEmployees));
	}

}
