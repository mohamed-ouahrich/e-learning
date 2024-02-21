package com.example.login.repository;

import com.example.login.entity.Course;
import com.example.login.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByTopic(Topic topic);
}
