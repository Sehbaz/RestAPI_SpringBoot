package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();

    Course getCourse(long parseLong);

    Course addCourse(Course course);

    void deleteCourse(long parseLong);

    Course updateCourse(Course course);
}
