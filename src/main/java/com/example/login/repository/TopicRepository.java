package com.example.login.repository;

import com.example.login.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    @Query("SELECT t FROM Topic t WHERE " +
            "t.name LIKE CONCAT('%',:query,'%') OR " +
            "t.description LIKE CONCAT('%',:query,'%')")
    List<Topic> searchTopics(String query);
}
