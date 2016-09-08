package mil.dha.health.dveivr

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.junit.Test

import static org.junit.Assert.*;

/**
 * Loading Reports test
 */
class LoadingReportTest {

    @Test
    void testSerialization() {
        LoadingReport report = new LoadingReport()
        report.completedDate = new Date()
        report.cutoffTime = new Date()
        report.importReports = new LinkedList<>()

        PatientImportReport patientImportReport = new PatientImportReport()
        patientImportReport.patientId = "1234"
        patientImportReport.encounterImportReportList = new LinkedList<>()
        patientImportReport.patientSuccess = true
        patientImportReport.log = "None"
        report.importReports.add(patientImportReport)

        EncounterImportReport encounterImportReport = new EncounterImportReport()
        encounterImportReport.encounterId = "5678"
        encounterImportReport.success = true
        encounterImportReport.log = "None"
        patientImportReport.encounterImportReportList.add(encounterImportReport)

        print(JsonOutput.toJson(report))
    }
}
