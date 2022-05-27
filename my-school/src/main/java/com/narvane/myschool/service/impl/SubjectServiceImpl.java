package com.narvane.myschool.service.impl;

import com.narvane.myschool.domain.subject.Subject;
import com.narvane.myschool.exception.ResourceNotFoundException;
import com.narvane.myschool.repository.SubjectRepository;
import com.narvane.myschool.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    private static final String SUBJECT_NOT_FOUNDED = "Subject not founded";

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject update(Subject update) {

        Subject subject = subjectRepository.findById(update.getId())
                .orElseThrow(() -> new ResourceNotFoundException(SUBJECT_NOT_FOUNDED));

        subject.setName(update.getName());

        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(SUBJECT_NOT_FOUNDED));
    }

    @Override
    public Page<Subject> findAll(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }

}
