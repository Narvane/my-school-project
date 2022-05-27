package com.narvane.myschool.service;

import com.narvane.myschool.domain.subject.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectService {

    Subject save(Subject subject);

    Subject update(Subject subject);

    void delete(Long id);

    Subject findById(Long id);

    Page<Subject> findAll(Pageable pageable);

}
