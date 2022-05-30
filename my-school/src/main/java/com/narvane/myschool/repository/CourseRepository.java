package com.narvane.myschool.repository;

import com.narvane.myschool.domain.course.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CourseRepository extends PagingAndSortingRepository<Course, UUID> {

}
