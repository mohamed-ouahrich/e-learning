package com.example.login.controller;

import com.example.login.entity.Topic;
import com.example.login.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class SearchController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        List<Topic> searchResults = topicService.searchTopics(query);

        if (searchResults.isEmpty()) {
            model.addAttribute("message", "No results found for your search.");
        } else {
            model.addAttribute("topics", searchResults);
        }

        return "search-results";
    }

    @GetMapping("/topics/{id}")
    public String viewTopic(@PathVariable Long id, Model model) {
        Topic topic = topicService.findById(id);

        if (topic != null) {
            // Use different names for videos and courses to avoid conflicts
            model.addAttribute("relatedVideos", topicService.getRelatedVideos(topic));
            model.addAttribute("relatedCourses", topicService.getRelatedCourses(topic));
            model.addAttribute("relatedDocumentation", topicService.getRelatedDocumentation(topic));
            // Use singular form "topic" when adding a single topic to the model
            model.addAttribute("topic", topic);
            return "search-results";
        } else {
            return "redirect:/search?query=";
        }
    }

}
