package com.iiht.StudentMarks.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.StudentMarks.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	Iterable<Student> findAll(Sort sort);

}
