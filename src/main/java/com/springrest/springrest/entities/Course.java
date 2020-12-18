package com.springrest.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    private Long courseID;
    private String title;
    private String description;

    //making Constructor
    public Course(Long courseID, String title, String description) {
        this.courseID = courseID;
        this.title = title;
        this.description = description;
    }

    //generating the defauly constructor from super class
    public Course(){
        super();
    }


    //Getter and Setter method
    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //To String method
    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
