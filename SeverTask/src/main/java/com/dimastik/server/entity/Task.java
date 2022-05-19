package com.dimastik.server.entity;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "tm_task", schema = "public")
public class Task {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public Task() {
    }

    public Task(Integer userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Task(Long id, Integer userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer user_id) {
        this.userId = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Task.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userId=" + userId)
                .add("title='" + title + "'")
                .add("description='" + description + "'")
                .toString();
    }
}
