package com.example.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Constant.Operation;
import com.example.Exception.CustomException;
import com.example.dto.EmployeeDto;
import com.example.models.Department;
import com.example.models.Employee;
import com.example.models.Skills;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.SkillsRepository;
import com.example.utlis.UtilsClass;

/**
 * @author Sanyuja Employee Service
 */
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository emprepo;

	@Autowired
	DepartmentRepository deptrepo;

	@Autowired
	SkillsRepository skillrepo;

	@Autowired
	UtilsClass utilsclass;

	@SuppressWarnings("unused")
	private Employee employeedetails(EmployeeDto empdto, Operation op) throws CustomException {

		Employee emp = null;
		Department department;

		if (op == Operation.INSERT) {
			emp = new Employee();

		} else if (op == Operation.UPDATE) {

			Optional<Integer> id = empdto.getId();
			if (!id.isPresent())
				throw new CustomException("Employee id is not present");
			int employeeid = id.get();
			Optional<Employee> ee = emprepo.findById(employeeid);

			if (!ee.isPresent())
				throw new CustomException("Not Present");

			emp = ee.get();

			List<Integer> list = empdto.getSkillid();
			// get skills from employee
			List<Skills> empskills = emp.getSkills();

			// list.forEach(s->System.out.println(s));
			// iterate list
			for (Integer s : list) {
				System.out.println(s);

				// list.forEach(s->System.out.println(s));

				Optional<Skills> skills = skillrepo.findById(s);
				// get skills
				Skills newskills = skills.get();
				// check whether employee list contains skills
				if (!empskills.contains(newskills))
					empskills.add(newskills);

			}

		}
		int id = empdto.getDepartment_id();
		Optional<Department> dept = deptrepo.findById(id);

		if (!dept.isPresent())
			throw new CustomException("Department does not exist");

		String empname = empdto.getEmp_name();

		emp.setEmp_name(empname);

		double empsal = empdto.getSalary();
		emp.setSalary(empsal);

		Date date = empdto.getJoining_date();
		emp.setJoining_date(date);

		String email = empdto.getEmail_id();
		boolean status = utilsclass.utilmethod(email);
		if (!status)
			throw new CustomException("Require proper email format");
		emp.setEmailid(email);
		boolean active = empdto.isActive();
		emp.setActive(active);

		Department dept1 = dept.get();
		emp.setDept(dept1);
		// Employee employee = emprepo.save(emp);
		try {
			return emprepo.save(emp);

		} catch (Exception ex) {
			throw new CustomException("Constraint violation Exception");
		}

	}

	public Employee empinsert(EmployeeDto empdto) throws CustomException {
		return employeedetails(empdto, Operation.INSERT);

	}

	public List<Employee> empsalary(String dept_name) {
		// get department name
		List<Employee> emp = emprepo.fetchemp(dept_name);
		return emp;

	}

	public List<Employee> empdate(String dept_name) {
		// get department name
		List<Employee> emp = emprepo.fetchbydate(dept_name);
		return emp;
	}

	public Employee empupdate(EmployeeDto empdto) throws CustomException {

		return employeedetails(empdto, Operation.UPDATE);

	}

	public List<Employee> listemp(String dept_name) {
		// retieve department by name
		List<Employee> emp = emprepo.fetchempbyname(dept_name);
		return emp;
	}

	public Employee empdelete(int id) throws CustomException {
		// retrieve by id
		Optional<Employee> emp = emprepo.findById(id);
		if (!emp.isPresent())
			throw new CustomException("Employee is not present");

		// retrieve employee
		Employee employee = emp.get();
		// set flag to false
		employee.setActive(false);
		return emprepo.save(employee);
	}
	
	public List<Employee> getallemployees()
	{
		List<Employee> emp=new ArrayList<Employee>();
		emprepo.findAll().forEach(emp::add);
		List<Employee> emplist = emp.stream().sorted(Comparator.comparing(Employee::getEmp_name)).collect(Collectors.toList());
		int ss = emplist.size();
		return emplist;
		
	}

}
