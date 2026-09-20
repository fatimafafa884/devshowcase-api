package com.devshowcase.api.dto;
import jakarta.validation.constraints.NotBlank;

public class TechnologyDTO {
	
	@NotBlank
    private String name;

    public TechnologyDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}