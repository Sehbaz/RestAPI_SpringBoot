package com.springrest.springrest.dao;

import com.springrest.springrest.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

// Course is the Enitity and Long is the type of ID (primary key)
public interface CourseDao extends JpaRepository<Course,Long> {
}
