package com.narvane.myschool.controller;


import com.narvane.myschool.controller.input.CourseInput;
import com.narvane.myschool.controller.model.CourseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

public interface CourseController {

    ResponseEntity<CourseModel> createCourse(CourseInput courseInput);

    ResponseEntity<CourseModel> updateCourse(CourseInput courseInput);

    ResponseEntity<Void> deleteCourseById(Long id);

    ResponseEntity<CourseModel> findCourseById(Long id);

    ResponseEntity<Page<CourseModel>> findAllCourses(int page, int size, Sort.Direction direction, String... properties);

}
