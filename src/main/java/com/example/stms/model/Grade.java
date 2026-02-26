package com.example.stms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "enrollment_id", nullable = false)
    private Enrollment enrollment;

    @Min(0)
    @Max(100)
    private Double score;

    private String comments;

    public Grade() {
    }

    public Grade(Long id, Enrollment enrollment, Double score, String comments) {
        this.id = id;
        this.enrollment = enrollment;
        this.score = score;
        this.comments = comments;
    }

    public static GradeBuilder builder() {
        return new GradeBuilder();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // Simple Builder class
    public static class GradeBuilder {
        private Long id;
        private Enrollment enrollment;
        private Double score;
        private String comments;

        public GradeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public GradeBuilder enrollment(Enrollment enrollment) {
            this.enrollment = enrollment;
            return this;
        }

        public GradeBuilder score(Double score) {
            this.score = score;
            return this;
        }

        public GradeBuilder comments(String comments) {
            this.comments = comments;
            return this;
        }

        public Grade build() {
            return new Grade(id, enrollment, score, comments);
        }
    }
}
