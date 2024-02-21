package com.example.login.repository;

import com.example.login.entity.Topic;
import com.example.login.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {
    List<Video> findByTopic(Topic topic);
}
