package com.narvane.myschool.repository;

import com.narvane.myschool.domain.subject.Subject;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface SubjectRepository extends PagingAndSortingRepository<Subject, UUID> {

}
