package com.narvane.myschool.controller;

import com.narvane.myschool.controller.input.SubjectInput;
import com.narvane.myschool.controller.model.SubjectModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

public interface SubjectController {

    ResponseEntity<SubjectModel> createSubject(SubjectInput subjectInput);

    ResponseEntity<SubjectModel> updateSubject(SubjectInput subjectInput);

    ResponseEntity<Void> deleteSubjectById(Long id);

    ResponseEntity<SubjectModel> findSubjectById(Long id);

    ResponseEntity<Page<SubjectModel>> findAllSubjects(int page, int size, Sort.Direction direction, String... properties);

}
