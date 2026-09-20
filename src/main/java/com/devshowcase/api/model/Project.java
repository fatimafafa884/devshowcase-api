package com.devshowcase.api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String url;
    
    @ManyToOne
    private Profile profile;
    @OneToMany(mappedBy = "project")
    private List<Feedback> feedbacks;
    @ManyToMany
    @JoinTable(
    	    name = "project_technology",
    	    joinColumns = @JoinColumn(name = "project_id"),
    	    inverseJoinColumns = @JoinColumn(name = "technology_id")
    	)
    private List<Technology> technologies;

    public Project() {
    }

    public Project(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public Long getId() {
        return id;
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
}