package com.narvane.myreport.service;

import com.narvane.myreport.domain.model.Report;

public interface ReportService {

    Report createReport(Report report);

    void updateReport(Report report);

    void deleteReport(Report report);

    Report getReport(String reportId) throws Exception;

}
