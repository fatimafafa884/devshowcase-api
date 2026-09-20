package com.devshowcase.api.dto;

public class ProfileResponseDTO {

    private Long id;
    private String name;
    private String bio;
    private String email;

    public ProfileResponseDTO() {
    }

    public ProfileResponseDTO(Long id, String name, String bio, String email) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.email = email;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}