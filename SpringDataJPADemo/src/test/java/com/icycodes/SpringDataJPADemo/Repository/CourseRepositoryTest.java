package com.icycodes.SpringDataJPADemo.Repository;

import com.icycodes.SpringDataJPADemo.Entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void getCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }


}