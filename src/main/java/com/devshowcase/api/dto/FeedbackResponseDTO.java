package com.devshowcase.api.dto;

public class FeedbackResponseDTO {

    private Long id;
    private String comment;
    private Long projectId;

    public FeedbackResponseDTO() {
    }

    public FeedbackResponseDTO(Long id, String comment, Long projectId) {
        this.id = id;
        this.comment = comment;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}