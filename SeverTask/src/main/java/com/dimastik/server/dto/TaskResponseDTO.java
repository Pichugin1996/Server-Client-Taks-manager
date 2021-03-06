package com.dimastik.server.dto;

import com.dimastik.server.entity.Task;

public class TaskResponseDTO {

    private Long id;
    private Integer userId;
    private String title;
    private String description;

    public TaskResponseDTO(Long id, Integer userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public TaskResponseDTO(Task task) {
        this.id = task.getId();
        this.userId = task.getUserId();
        this.title = task.getTitle();
        this.description = task.getDescription();
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

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
