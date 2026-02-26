package com.example.stms.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private LocalDate enrollmentDate;

    public Enrollment() {
    }

    public Enrollment(Long id, Student student, Course course, LocalDate enrollmentDate) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public static EnrollmentBuilder builder() {
        return new EnrollmentBuilder();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    // Simple Builder class
    public static class EnrollmentBuilder {
        private Long id;
        private Student student;
        private Course course;
        private LocalDate enrollmentDate;

        public EnrollmentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EnrollmentBuilder student(Student student) {
            this.student = student;
            return this;
        }

        public EnrollmentBuilder course(Course course) {
            this.course = course;
            return this;
        }

        public EnrollmentBuilder enrollmentDate(LocalDate enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
            return this;
        }

        public Enrollment build() {
            return new Enrollment(id, student, course, enrollmentDate);
        }
    }
}
