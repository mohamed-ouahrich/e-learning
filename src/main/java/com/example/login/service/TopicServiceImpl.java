package com.example.login.service;

import com.example.login.entity.Course;
import com.example.login.entity.Documentation;
import com.example.login.entity.Topic;
import com.example.login.entity.Video;
import com.example.login.repository.CourseRepository;
import com.example.login.repository.DocumentationRepository;
import com.example.login.repository.TopicRepository;
import com.example.login.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private DocumentationRepository documentationRepository;
    @Override
    public List<Topic> searchTopics(String query) {
        return topicRepository.searchTopics(query);
    }

    @Override
    public List<Video> getRelatedVideos(Topic topic) {
        return videoRepository.findByTopic(topic);
    }

    @Override
    public List<Course> getRelatedCourses(Topic topic) {
        return courseRepository.findByTopic(topic);
    }

    @Override
    public List<Documentation> getRelatedDocumentation(Topic topic) {
        return documentationRepository.findByTopic(topic);
    }


    @Override
    public Topic findById(Long id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        return optionalTopic.orElse(null);
    }
}
