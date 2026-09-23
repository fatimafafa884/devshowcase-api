package com.devshowcase.api.dto;

public class ProjectResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String url;
    private Double averageRating;

    public ProjectResponseDTO() {
    }

    public ProjectResponseDTO(Long id, String name, String description, String url, Double averageRating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.averageRating = averageRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}