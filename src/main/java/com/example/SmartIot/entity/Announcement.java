package com.example.SmartIot.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private LocalDate publish_time;

    //constructor
    public Announcement() {
    }

    public Announcement(Long id, String title, String content, LocalDate publish_time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publish_time = publish_time;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(LocalDate publish_time) {
        this.publish_time = publish_time;
    }

    

}
