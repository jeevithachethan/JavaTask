package com.example.StudentDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Course;
import com.sun.xml.bind.v2.model.core.ID;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
