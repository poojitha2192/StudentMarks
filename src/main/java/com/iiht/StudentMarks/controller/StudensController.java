package com.iiht.StudentMarks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.StudentMarks.model.Student;
import com.iiht.StudentMarks.repository.StudentRepository;

@RestController
public class StudensController {

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/getAllStudents")
	public List<Student> getAllStudentsByNameAsc() {
		return (List<Student>) studentRepository.findAll(Sort.by("name").ascending());
	}

	@GetMapping("/getStudentById/{id}")
	public Optional<Student> getAllStudentById(@PathVariable Long id) {
		return studentRepository.findById(id);
	}

	@GetMapping("/getStudentById/{id}/{marks}")
	public Student getAllStudentByIdAndMarks(@PathVariable Long id, @PathVariable Long marks) {
		Student student = studentRepository.findById(id).orElse(null);

		if (student != null) {
			student.setMarks(marks);
			student = studentRepository.save(student);

			return student;
		}
		throw new RuntimeException("Student not available");
	}

}
