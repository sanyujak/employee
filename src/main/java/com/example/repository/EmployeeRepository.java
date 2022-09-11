package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Employee;


/**
 * @author agsuser
 * Employee repository
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	@Query(value = "select e.* from employee e join department d on e.department_id=d.id where dept_name=:dept_name and active=1 ORDER BY salary desc", nativeQuery = true)
	List<Employee> fetchemp(@Param("dept_name") String dept_name);

	@Query(value = "select e.* from employee e join department d on e.department_id=d.id where dept_name=:dept_name and active=1 ORDER BY joining_date desc", nativeQuery = true)
	List<Employee> fetchbydate(@Param("dept_name") String dept_name);

	@Query(value = "select e.* from employee e join department d on e.department_id=d.id where dept_name=:dept_name ORDER BY emp_name", nativeQuery = true)
	List<Employee> fetchempbyname(@Param("dept_name") String dept_name);

}
