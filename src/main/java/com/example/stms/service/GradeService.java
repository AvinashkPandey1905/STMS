package com.example.stms.service;

import com.example.stms.model.Enrollment;
import com.example.stms.model.Grade;
import com.example.stms.repository.GradeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;
    private final EnrollmentService enrollmentService;

    public GradeService(GradeRepository gradeRepository, EnrollmentService enrollmentService) {
        this.gradeRepository = gradeRepository;
        this.enrollmentService = enrollmentService;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public List<Grade> getGradesByEnrollment(Long enrollmentId) {
        return gradeRepository.findByEnrollmentId(enrollmentId);
    }

    @Transactional
    public Grade assignGrade(Long enrollmentId, Double score, String comments) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(enrollmentId);

        Grade grade = Grade.builder()
                .enrollment(enrollment)
                .score(score)
                .comments(comments)
                .build();

        return gradeRepository.save(grade);
    }

    @Transactional
    public Grade updateGrade(Long id, Double score, String comments) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + id));
        grade.setScore(score);
        grade.setComments(comments);
        return gradeRepository.save(grade);
    }

    @Transactional
    public void deleteGrade(Long id) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + id));
        gradeRepository.delete(grade);
    }
}
