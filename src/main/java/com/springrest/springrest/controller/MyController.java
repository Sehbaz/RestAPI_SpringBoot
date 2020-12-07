package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    // Landing to home page
    @GetMapping("/home")
    public String home(){
        return "Welcome to the Course Application.";
    }

    // getting all the courses
    @GetMapping("/courses")
    public List<Course> getCources(){
        return this.courseService.getCourses();
    }

    //getting the course by ID
    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseID){
        return this.courseService.getCourse(Long.parseLong(courseID));
    }

    //Adding the new course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    //Deleting the course by ID
    @DeleteMapping("/courses/{courseID}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID){
       try{
           this.courseService.deleteCourse(Long.parseLong(courseID));
           return new ResponseEntity<>(HttpStatus.OK);
       }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    //Updating the data using the id
    @PutMapping("/courses/{courseID}")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

}
