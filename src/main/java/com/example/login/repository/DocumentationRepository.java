package com.example.login.repository;

import com.example.login.entity.Documentation;
import com.example.login.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentationRepository extends JpaRepository<Documentation,Long> {
    List<Documentation> findByTopic(Topic topic);
}
