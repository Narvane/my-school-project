package com.narvane.myschool.controller.impl;

import com.narvane.myschool.assembler.Assembler;
import com.narvane.myschool.controller.CourseController;
import com.narvane.myschool.controller.input.CourseInput;
import com.narvane.myschool.controller.model.CourseModel;
import com.narvane.myschool.domain.course.Course;
import com.narvane.myschool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseControllerImpl implements CourseController {

    private final CourseService courseService;
    private final Assembler<Course, CourseInput, CourseModel> assembler;

    @Autowired
    public CourseControllerImpl(CourseService courseService, Assembler<Course, CourseInput, CourseModel> assembler) {
        this.courseService = courseService;
        this.assembler = assembler;
    }

    @Override
    @PostMapping
    public ResponseEntity<CourseModel> createCourse(@RequestBody @Valid CourseInput courseInput) {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<CourseModel> updateCourse(@RequestBody @Valid CourseInput courseInput) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CourseModel> findCourseById(@PathVariable Long id) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<CourseModel>> findAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "name") String... properties
    ) {
        return null;
    }

}
