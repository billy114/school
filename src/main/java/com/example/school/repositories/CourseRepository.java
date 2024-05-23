package com.example.school.repositories;

import com.example.school.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long id);
    List<Course> findAll();
    Course save(Course course);
    List<Course> findByDescriptionContaining(String word);
}
