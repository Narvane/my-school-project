package com.narvane.myreport.controller;

import com.narvane.myreport.domain.model.Report;

public interface ReportController {

    Report createReport(Report report);

    void updateReport(Report report);

    void deleteReport(Report report);

    Report getReport(String reportId) throws Exception;

}
