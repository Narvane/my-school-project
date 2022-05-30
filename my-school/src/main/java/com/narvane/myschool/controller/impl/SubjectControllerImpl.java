package com.narvane.myschool.controller.impl;

import com.narvane.myschool.assembler.Assembler;
import com.narvane.myschool.controller.SubjectController;
import com.narvane.myschool.dto.input.SubjectInput;
import com.narvane.myschool.dto.model.SubjectModel;
import com.narvane.myschool.domain.subject.Subject;
import com.narvane.myschool.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/subject")
public class SubjectControllerImpl implements SubjectController {

    private final SubjectService service;
    private final Assembler<Subject, SubjectInput, SubjectModel> assembler;

    @Autowired
    public SubjectControllerImpl(SubjectService service, Assembler<Subject, SubjectInput, SubjectModel> assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Override
    @PostMapping
    public ResponseEntity<SubjectModel> createSubject(@RequestBody @Validated SubjectInput subjectInput) {
        return new ResponseEntity<>(
                assembler.assembleModel(service.save(assembler.assembleEntity(subjectInput))),
                HttpStatus.CREATED
        );
    }

    @Override
    @PutMapping
    public ResponseEntity<SubjectModel> updateSubject(@RequestBody @Validated SubjectInput subjectInput) {
        return new ResponseEntity<>(
                assembler.assembleModel(service.update(assembler.assembleEntity(subjectInput))),
                HttpStatus.OK
        );
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubjectById(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SubjectModel> findSubjectById(@PathVariable String id) {
        return new ResponseEntity<>(
                assembler.assembleModel(service.findById(id)),
                HttpStatus.OK
        );
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<SubjectModel>> findAllSubjects(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "name") String... properties) {

        Pageable pageable = PageRequest.of(page, size, direction, properties);

        return new ResponseEntity<>(
                assembler.assemblePageModel(service.findAll(pageable)),
                HttpStatus.OK
        );

    }

}

