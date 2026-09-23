package com.devshowcase.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class FeedbackDTO {private Long id;

@NotBlank
private String comment;

@Min(1)
@Max(5)
private Integer rating;

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
public Integer getRating() {
    return rating;
}

public void setRating(Integer rating) {
    this.rating = rating;
}
public Long getProjectId() {
	return projectId;
}
public void setProjectId(Long projectId) {
	this.projectId = projectId;
}

}
