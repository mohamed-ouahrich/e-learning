package com.example.login.service;

import com.example.login.entity.Course;
import com.example.login.entity.Documentation;
import com.example.login.entity.Topic;
import com.example.login.entity.Video;

import java.util.List;

public interface TopicService {
    List<Topic> searchTopics(String query);
    List<Video> getRelatedVideos(Topic topic);
    List<Course> getRelatedCourses(Topic topic);

    List<Documentation> getRelatedDocumentation(Topic topic);

    Topic findById(Long id);
}
