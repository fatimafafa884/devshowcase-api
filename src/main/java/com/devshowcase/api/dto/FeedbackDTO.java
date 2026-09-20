package com.devshowcase.api.dto;

import jakarta.validation.constraints.NotBlank;

public class FeedbackDTO {private Long id;

@NotBlank
private String comment;
private Long projectId;
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
