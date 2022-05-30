package com.narvane.myschool.assembler.impl;

import com.narvane.myschool.assembler.Assembler;
import com.narvane.myschool.dto.input.CourseInput;
import com.narvane.myschool.dto.model.CourseModel;
import com.narvane.myschool.domain.course.Course;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CourseAssembler implements Assembler<Course, CourseInput, CourseModel> {

    @Override
    public Course assembleEntity(CourseInput courseInput) {
        return null;
    }

    @Override
    public CourseModel assembleModel(Course course) {
        return null;
    }

    @Override
    public Collection<Course> assembleEntityCollection(Collection<CourseInput> input) {
        return null;
    }

    @Override
    public Collection<CourseModel> assembleModelCollection(Collection<Course> entity) {
        return null;
    }

    @Override
    public Page<CourseModel> assemblePageModel(Page<Course> courses) {
        return null;
    }

}
