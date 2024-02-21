package com.example.login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "documentation")
public class Documentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dc")
    private Long id;
    private String title;
    private String url;

    // Getters, setters, and other annotations

    @ManyToOne
    @JoinColumn(name = "id_topic")
    private Topic topic;
}
