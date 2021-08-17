package com.example.StudentDemo.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Model.Student;
import com.example.StudentDemo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	//to save student
	public Student saveStudent(Student student) {
		Student s = studentRepository.save(student);
		return s;
	}
	//To update student
	public Student updateStudent(Long studentId, @Valid Student student) throws StudentNotFoundException {
		Student s = studentRepository.getById(studentId);
		if (s!=null) {
			s.setStudentName(student.getStudentName());
			studentRepository.save(s);
		}
		return student;

	}

	public List<Student> FindAllStudents() {
		List<Student> student = studentRepository.findAll();
		return student;

	}

	public void deleteStudent(Long stdentId) throws StudentNotFoundException {
		Optional<Student> s = studentRepository.findById(stdentId);
		if (s.isPresent()) {
			studentRepository.deleteById(stdentId);
		} else
			throw new StudentNotFoundException("Student Not Avaliable");

	}
}