package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseDao courseDao;
    //List<Course> list;

    public CourseServiceImpl(){
    //    list = new ArrayList<>();
    //    list.add(new Course((long) 1112,"Java course 1","this is first source"));
    //    list.add(new Course((long) 2222,"Java course 2","this is second source"));
    }


    //Printing all the courses available in the database
    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    //Finding the records from the database
    @Override
    public Course getCourse(long parseLong) {


        /*
        Course c=null;
        for(Course course:list){
            if(course.getCourseID()==parseLong){
                c=course;
                break;
            }
        }

         */
        return courseDao.getOne(parseLong);
    }

    @Override
    public Course addCourse(Course course) {
    //    list.add(course);

        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        Course entityOne=courseDao.getOne(parseLong);
        courseDao.delete(entityOne);
    //    list=this.list.stream().filter(e->e.getCourseID()!=parseLong).collect(Collectors.toList());
    }

    @Override
    public Course updateCourse(Course course) {
        /*
        list.forEach(e->{
            if(e.getCourseID()==course.getCourseID()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });

         */
        //this will work similar to add data if data does not exist then it will create new or if existing will be updated
        courseDao.save(course);
        return course;
    }


}
