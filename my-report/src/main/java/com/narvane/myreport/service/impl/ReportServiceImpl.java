package com.narvane.myreport.service.impl;

import com.narvane.myreport.domain.model.Report;
import com.narvane.myreport.repository.ReportRepository;
import com.narvane.myreport.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void updateReport(Report update) {
        Report report = reportRepository.findById(update.getId()).get();
        reportRepository.save(update);
    }

    @Override
    public void deleteReport(Report report) {
        reportRepository.delete(report);
    }

    @Override
    public Report getReport(String reportId) throws Exception {
        return reportRepository.findById(reportId).get();
    }

}
