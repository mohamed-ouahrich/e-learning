package com.example.login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_topic")
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Video> videos;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Course> courses;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Documentation> documentations;
}
