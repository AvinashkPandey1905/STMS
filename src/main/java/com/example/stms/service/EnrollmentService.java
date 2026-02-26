package com.example.stms.service;

import com.example.stms.model.Course;
import com.example.stms.model.Enrollment;
import com.example.stms.model.Student;
import com.example.stms.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentService studentService,
            CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
    }

    @Transactional
    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);

        // Check if already enrolled
        boolean alreadyEnrolled = enrollmentRepository.findByStudentId(studentId).stream()
                .anyMatch(e -> e.getCourse().getId().equals(courseId));

        if (alreadyEnrolled) {
            throw new RuntimeException("Student is already enrolled in this course");
        }

        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .enrollmentDate(LocalDate.now())
                .build();

        return enrollmentRepository.save(enrollment);
    }

    @Transactional
    public void cancelEnrollment(Long id) {
        Enrollment enrollment = getEnrollmentById(id);
        enrollmentRepository.delete(enrollment);
    }
}
