package com.narvane.myschool.service.impl;

import com.narvane.myschool.domain.course.Course;
import com.narvane.myschool.exception.ResourceNotFoundException;
import com.narvane.myschool.repository.CourseRepository;
import com.narvane.myschool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    private static final String COURSE_NOT_FOUNDED = "Course not founded";

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course update(Course update) {

        Course course = courseRepository.findById(update.getId())
                .orElseThrow(() -> new ResourceNotFoundException(COURSE_NOT_FOUNDED));

        course.setName(update.getName());
        course.setDegrees(update.getDegrees());

        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void delete(String id) {
        courseRepository.deleteById(UUID.fromString(id));
    }

    @Override
    @Transactional
    public Course findById(String id) {
        return courseRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResourceNotFoundException(COURSE_NOT_FOUNDED));
    }

    @Override
    @Transactional
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

}
