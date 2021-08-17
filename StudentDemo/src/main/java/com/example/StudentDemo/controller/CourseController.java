package com.example.StudentDemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Course;
import com.example.StudentDemo.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	/*
	 * To save the data
	 */
	@PostMapping("/course")
	public Course createCourse(Course course) {
		return courseService.saveCourse(course);
	}
		/*
		 * To get the course
		 */
		@GetMapping("/courses")
		public List<Course> getCourseDetails() {
			List<Course> course=courseService.FindAllCourses();
			return course;
			
		}
		@PutMapping("course/{courseId}")
		public Course updateCourse(@PathVariable Long courseId,@Valid Course course) {
			Course c=CourseService.updateCourseDetails(courseId);
			return c;
			
		}
	}
