package com.narvane.myschool.service.impl;

import com.narvane.myschool.domain.subject.Subject;
import com.narvane.myschool.exception.ResourceNotFoundException;
import com.narvane.myschool.repository.SubjectRepository;
import com.narvane.myschool.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class SubjectServiceImpl implements SubjectService {

    private static final String SUBJECT_NOT_FOUNDED = "Subject not founded";

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    @Transactional
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    @Transactional
    public Subject update(Subject update) {

        Subject subject = subjectRepository.findById(update.getId())
                .orElseThrow(() -> new ResourceNotFoundException(SUBJECT_NOT_FOUNDED));

        subject.setName(update.getName());

        return subjectRepository.save(subject);
    }

    @Override
    @Transactional
    public void delete(String id) {
        subjectRepository.deleteById(UUID.fromString(id));
    }

    @Override
    @Transactional
    public Subject findById(String id) {
        return subjectRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResourceNotFoundException(SUBJECT_NOT_FOUNDED));
    }

    @Override
    @Transactional
    public Page<Subject> findAll(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }

}
