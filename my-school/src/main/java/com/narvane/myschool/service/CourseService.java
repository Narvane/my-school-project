package com.narvane.myschool.service;

import com.narvane.myschool.domain.course.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    Course save(Course course);

    Course update(Course course);

    void delete(String id);

    Course findById(String id);

    Page<Course> findAll(Pageable pageable);

}
