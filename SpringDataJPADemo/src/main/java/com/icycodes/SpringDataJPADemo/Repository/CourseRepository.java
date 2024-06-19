package com.icycodes.SpringDataJPADemo.Repository;

import com.icycodes.SpringDataJPADemo.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
