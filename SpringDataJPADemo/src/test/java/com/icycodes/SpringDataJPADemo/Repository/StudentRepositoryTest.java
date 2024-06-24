package com.icycodes.SpringDataJPADemo.Repository;

import com.icycodes.SpringDataJPADemo.Entity.Guardian;
import com.icycodes.SpringDataJPADemo.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveStudent() {
        Guardian guardian = Guardian.builder()
                .email("vis@gmail.com")
                .name("vis")
                .phoneNumber("9876543210")
                .build();
        Student student = Student.builder()
                .firstName("tushar")
                .lastName("chaudhary")
                .emailId("tushar@gmail.com")
                .phoneNumber("4567891230")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student list is : " + studentList);
    }

    @Test
    public void printStudentsBasedOnFirstName(){
        List<Student> students = studentRepository.findByFirstName("harsh");
        System.out.println(students);
    }

    @Test
    public void printStudentsContainsName(){
        List<Student> students = studentRepository.findByFirstNameContaining("ar");
        System.out.println(students);
    }

    @Test
    public void printStudentsByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("dev");
        System.out.println(students);
    }


    @Test
    public void printStudentsByLastNameNotNull(){
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println(students);
    }

    @Test
    public void printStudentsByEmailId(){
        List<Student> students = studentRepository.findByEmailId("harsh@gmail.com");
        System.out.println(students);
    }

    @Test
    public void printStudentFirstNameByEmailId(){
        String studentFirstName = studentRepository.getStudentFirstNameByPhoneNumber("1234567890");
        System.out.println(studentFirstName);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Happy","1234567890");
    }

}