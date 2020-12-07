package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;

    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course((long) 1,"Java course 1","this is first source"));
        list.add(new Course((long) 2,"Java course 2","this is second source"));
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

}
