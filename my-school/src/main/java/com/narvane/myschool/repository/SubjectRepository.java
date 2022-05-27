package com.narvane.myschool.repository;

import com.narvane.myschool.domain.subject.Subject;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long> {

}
