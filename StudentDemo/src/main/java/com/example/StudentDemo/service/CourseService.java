package com.example.StudentDemo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Course;
import com.example.StudentDemo.repository.CourseRepository;
@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	//To save course details
	public Course saveCourse(Course course) {
		Course c=courseRepository.save(course);
		return c;
	}
	//to find all courses
	public List<Course> FindAllCourses() {
		List<Course> course=courseRepository.findAll();
		return course;
	}
	//Updating course
	public  Course updateCourseDetails(Long courseId,@Valid Course course) {
		Course c=courseRepository.getById(courseId);
		if(c!=null) {
			c.setCourseName(course.getCourseName());
			courseRepository.save(c);
			}
		return course;
		
	}
	//deleting course

}
