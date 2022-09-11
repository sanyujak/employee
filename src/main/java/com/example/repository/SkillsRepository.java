package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Skills;

/**
 * @author Sanyuja Kharat
 * Skills repository
 */
@Repository
public interface SkillsRepository extends /* CrudRepository<Skills, Integer>, */ JpaRepository<Skills, Integer> {

}
