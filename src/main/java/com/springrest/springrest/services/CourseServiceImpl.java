package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;

    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course((long) 1112,"Java course 1","this is first source"));
        list.add(new Course((long) 2222,"Java course 2","this is second source"));
    }


    //Printing all the courses available in the database
    @Override
    public List<Course> getCourses() {
        return list;
    }

    //Finding the records from the database
    @Override
    public Course getCourse(long parseLong) {
        Course c=null;
        for(Course course:list){
            if(course.getCourseID()==parseLong){
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        list=this.list.stream().filter(e->e.getCourseID()!=parseLong).collect(Collectors.toList());
    }

    @Override
    public Course updateCourse(Course course) {

        list.forEach(e->{
            if(e.getCourseID()==course.getCourseID()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }


}
