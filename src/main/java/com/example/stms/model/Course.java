package com.example.stms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course name is mandatory")
    private String name;

    @NotBlank(message = "Course code is mandatory")
    @Column(unique = true)
    private String code;

    private String description;

    private Integer credits;

    public Course() {
    }

    public Course(Long id, String name, String code, String description, Integer credits) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.credits = credits;
    }

    public static CourseBuilder builder() {
        return new CourseBuilder();
    }

    // Getters and Setters
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    // Simple Builder class
    public static class CourseBuilder {
        private Long id;
        private String name;
        private String code;
        private String description;
        private Integer credits;

        public CourseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CourseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CourseBuilder code(String code) {
            this.code = code;
            return this;
        }

        public CourseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CourseBuilder credits(Integer credits) {
            this.credits = credits;
            return this;
        }

        public Course build() {
            return new Course(id, name, code, description, credits);
        }
    }
}
