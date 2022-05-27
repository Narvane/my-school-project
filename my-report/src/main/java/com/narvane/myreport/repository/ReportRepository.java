package com.narvane.myreport.repository;

import com.narvane.myreport.domain.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {

}
