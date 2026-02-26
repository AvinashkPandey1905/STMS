package com.example.stms.controller;

import com.example.stms.model.Grade;
import com.example.stms.service.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/enrollment/{enrollmentId}")
    public List<Grade> getGradesByEnrollment(@PathVariable Long enrollmentId) {
        return gradeService.getGradesByEnrollment(enrollmentId);
    }

    @PostMapping
    public ResponseEntity<Grade> assignGrade(@RequestParam Long enrollmentId,
            @RequestParam Double score,
            @RequestParam(required = false) String comments) {
        return new ResponseEntity<>(gradeService.assignGrade(enrollmentId, score, comments), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id,
            @RequestParam Double score,
            @RequestParam(required = false) String comments) {
        return ResponseEntity.ok(gradeService.updateGrade(id, score, comments));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }
}
