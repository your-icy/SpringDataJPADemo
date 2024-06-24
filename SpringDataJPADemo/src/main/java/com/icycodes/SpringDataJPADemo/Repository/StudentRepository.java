package com.icycodes.SpringDataJPADemo.Repository;

import com.icycodes.SpringDataJPADemo.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);


    @Query(value = "select s from Student s where s.emailId = ?1")
    public List<Student> findByEmailId(String emailId);

    @Query(value = "select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailId(String emailId);

    @Query(value = "SELECT sd.first_name FROM student_data as sd where sd.phone_number = ?1", nativeQuery = true)
    public String getStudentFirstNameByPhoneNumber(String phoneNumber);

    @Transactional
    @Modifying
    @Query(value = "UPDATE student_data as sd SET sd.first_name = ?1 where sd.phone_number = ?2", nativeQuery = true)
    public int updateStudentNameByEmailId(String firstName , String phoneNumber);
}
