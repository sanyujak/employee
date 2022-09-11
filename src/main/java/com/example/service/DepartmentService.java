package com.example.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.CustomException;
import com.example.dto.DepartmentDto;
import com.example.models.Department;
import com.example.repository.DepartmentRepository;


/**
 * @author Sanyuja Kharat
 *         Department Service
 */
@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository deptrepo;

	public Department deptsave(DepartmentDto deptdto) {
		Department dept = new Department();
		dept.setDept_name(deptdto.getDept_name());

		return deptrepo.save(dept);

	}

	public Department updatedept(DepartmentDto dto) throws CustomException {
		//get department id
		Optional<Integer> id = dto.getId();
		
		//check if department is present
		if (!id.isPresent())
			throw new CustomException("Department id is not present");
		int id1 = id.get();
		Optional<Department> dept = deptrepo.findById(id1);

		//set department name by using getters of dto
		Department dd = dept.get();
		dd.setDept_name(dto.getDept_name());
		return deptrepo.save(dd);

	}

	public List<Department> getdept() {

		List<Department> dept = new ArrayList<Department>();
		//findall for finding all employees and then add to list by method reference
		deptrepo.findAll().forEach(dept::add);

		//
		List<Department> departments = dept.stream().sorted(Comparator.comparing(Department::getDept_name))
				.collect(Collectors.toList());

		return departments;

	}

}
