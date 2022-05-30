package com.narvane.myschool.assembler.impl;

import com.narvane.myschool.assembler.Assembler;
import com.narvane.myschool.dto.input.SubjectInput;
import com.narvane.myschool.dto.model.SubjectModel;
import com.narvane.myschool.domain.subject.Subject;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SubjectAssembler implements Assembler<Subject, SubjectInput, SubjectModel> {

    @Override
    public Subject assembleEntity(SubjectInput subjectInput) {
        return null;
    }

    @Override
    public SubjectModel assembleModel(Subject subject) {
        return null;
    }

    @Override
    public Collection<Subject> assembleEntityCollection(Collection<SubjectInput> input) {
        return null;
    }

    @Override
    public Collection<SubjectModel> assembleModelCollection(Collection<Subject> entity) {
        return null;
    }

    @Override
    public Page<SubjectModel> assemblePageModel(Page<Subject> subjects) {
        return null;
    }

}
