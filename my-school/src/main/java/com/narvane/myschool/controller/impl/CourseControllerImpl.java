package com.narvane.myschool.controller.impl;

import com.narvane.myschool.assembler.Assembler;
import com.narvane.myschool.controller.CourseController;
import com.narvane.myschool.dto.input.CourseInput;
import com.narvane.myschool.dto.model.CourseModel;
import com.narvane.myschool.domain.course.Course;
import com.narvane.myschool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseControllerImpl implements CourseController {

    private final CourseService service;
    private final Assembler<Course, CourseInput, CourseModel> assembler;

    @Autowired
    public CourseControllerImpl(CourseService service, Assembler<Course, CourseInput, CourseModel> assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Override
    @PostMapping
    public ResponseEntity<CourseModel> createCourse(@RequestBody @Validated CourseInput courseInput) {
        return new ResponseEntity<>(
                assembler.assembleModel(service.save(assembler.assembleEntity(courseInput))),
                HttpStatus.CREATED
        );
    }

    @Override
    @PutMapping
    public ResponseEntity<CourseModel> updateCourse(@RequestBody @Validated CourseInput courseInput) {
        return new ResponseEntity<>(
                assembler.assembleModel(service.update(assembler.assembleEntity(courseInput))),
                HttpStatus.OK
        );
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CourseModel> findCourseById(@PathVariable String id) {
        return new ResponseEntity<>(
                assembler.assembleModel(service.findById(id)),
                HttpStatus.OK
        );
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<CourseModel>> findAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "name") String... properties
    ) {

        Pageable pageable = PageRequest.of(page, size, direction, properties);

        return new ResponseEntity<>(
                assembler.assemblePageModel(service.findAll(pageable)),
                HttpStatus.OK
        );
    }

}
