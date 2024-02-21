package com.example.login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long id;
    private String courseName;
    private String CourseURL;

    // Getters, setters, and other annotations

    @ManyToOne
    @JoinColumn(name = "id_topic")
    private Topic topic;
}
