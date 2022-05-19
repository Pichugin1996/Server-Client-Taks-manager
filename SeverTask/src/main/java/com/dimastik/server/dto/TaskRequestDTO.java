package com.dimastik.server.dto;

public class TaskRequestDTO {

    private Integer userId;
    private String title;
    private String description;

    public TaskRequestDTO() {
    }

    public TaskRequestDTO(Integer userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
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
