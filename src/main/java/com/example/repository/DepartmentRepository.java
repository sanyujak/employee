package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Department;


/**
 * @author Sanyuja
 *
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
