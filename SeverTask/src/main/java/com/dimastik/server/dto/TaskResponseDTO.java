package com.dimastik.server.dto;

import com.dimastik.server.entity.Task;

public class TaskResponseDTO {

    private Long id;

    private Integer user_id;

    private String title;

    private String description;

    public TaskResponseDTO(Long id, Integer user_id, String title, String description) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
    }

    public TaskResponseDTO(Task task) {
        this.id = task.getId();
        this.user_id = task.getUserId();
        this.title = task.getTitle();
        this.description = task.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
