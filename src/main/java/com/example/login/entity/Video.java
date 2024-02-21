package com.example.login.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_video")
    private Long id;
    private String videoTitle;
    private String Thumbnail;
    private String videoURL;

    @ManyToOne
    @JoinColumn(name = "id_topic")
    private Topic topic;
}

