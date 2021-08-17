package com.example.StudentDemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Student;
import com.example.StudentDemo.service.StudentNotFoundException;
import com.example.StudentDemo.service.StudentService;

@RestController
@RequestMapping
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	List<Student> getStudent() {
		return studentService.FindAllStudents();

	}

	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@PutMapping("/student/{studentId}")
	public Student updateStudent(@PathVariable Long studentId, @Valid @RequestBody Student student)
			throws StudentNotFoundException {

		return studentService.updateStudent(studentId, student);
	}
	@DeleteMapping("/studentdelete/{studentId}")
	public void deleteStudent(@PathVariable Long studentId) throws StudentNotFoundException {
		studentService.deleteStudent(studentId);
	}

}
