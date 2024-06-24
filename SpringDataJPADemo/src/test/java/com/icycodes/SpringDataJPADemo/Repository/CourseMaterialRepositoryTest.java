package com.icycodes.SpringDataJPADemo.Repository;

import com.icycodes.SpringDataJPADemo.Entity.Course;
import com.icycodes.SpringDataJPADemo.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    public void saveCourse(){

        Course course = Course.builder()
                .courseTitle("java")
                .credits(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("https://www.oracle.com/")
                .build();

        courseMaterialRepository.save(courseMaterial);
        System.out.println(courseMaterial);
    }



    // or add spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true in yml file
    // or add @toString(course) on courseMaterial
    @Test
    public void printCourses(){
        List<CourseMaterial> courseMaterials =  courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }


    @Test
    public void pageResults(){

    }


}