package mil.dha.health.dveivr

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by phoehne on 9/8/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class LoadingReportServiceTest {

    @Autowired
    LoadingReportService loadingReportService

    @Test
    public void testLoadingReportService() {
        LoadingReport loadingReport = loadingReportService.lastReport()
    }

    @Test
    public void testLoadingReport() {
        LoadingReport report = new LoadingReport()

        report.reportId = UUID.randomUUID()
        report.completedDate = new Date()
        report.cutoffTime = new Date()
        report.importReports.add(new PatientImportReport("1234", true, "No Log"))

        PatientImportReport patientImportReport = new PatientImportReport("1235", true, "No log")
        patientImportReport.encounterImportReportList.add(new EncounterImportReport("1234", true))
        patientImportReport.encounterImportReportList.add(new EncounterImportReport("1235", true, "No Log"))

        report.importReports.add(patientImportReport)

        loadingReportService.saveReport(report)
    }
}
