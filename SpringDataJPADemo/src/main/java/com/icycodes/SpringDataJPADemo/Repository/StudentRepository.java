package com.icycodes.SpringDataJPADemo.Repository;

import com.icycodes.SpringDataJPADemo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public void saveStudent(Student student);

    public Student findByEmail(String Email);

    public Optional<Student> findById(Long id);

    public List<Student> findAll();

    public List<Student> findByGurdianName(String gurdianName);

    public List<Student> findByCourseName(String courseTitle);

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByLastName(String lastName);

}
