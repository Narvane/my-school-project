package com.narvane.myreport.controller.impl;

import com.narvane.myreport.controller.ReportController;
import com.narvane.myreport.domain.model.Report;
import com.narvane.myreport.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("my-report/report")
public class ReportControllerImpl implements ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportControllerImpl(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    @PostMapping
    public Report createReport(@Validated @RequestBody Report report) {
        return reportService.createReport(report);
    }

    @Override
    @PutMapping
    public void updateReport(@Validated @RequestBody Report report) {
        reportService.updateReport(report);
    }

    @Override
    @DeleteMapping
    public void deleteReport(Report report) {
        reportService.deleteReport(report);
    }

    @Override
    @GetMapping("/{reportId}")
    public Report getReport(@PathVariable("reportId") String reportId) throws Exception {
        return reportService.getReport(reportId);
    }
}
