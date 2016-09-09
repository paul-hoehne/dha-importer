package mil.dha.health.dveivr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * This is a report of what happend when attempting to load data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoadingReport {
    private UUID reportId;
    private Date completedDate;
    private Date cutoffTime;
    private boolean success;
    private String log;
    private List<PatientImportReport> importReports;

    public LoadingReport() {
        importReports = new LinkedList<>();
    }

    public PatientImportReport startPatient(int patientId) {
        PatientImportReport patientImportReport = new PatientImportReport();

        patientImportReport.setPatientId(patientId);
        importReports.add(patientImportReport);

        return patientImportReport;
    }

    public UUID getReportId() {
        return reportId;
    }

    public void setReportId(UUID reportId) {
        this.reportId = reportId;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Date getCutoffTime() {
        return cutoffTime;
    }

    public void setCutoffTime(Date cutoffTime) {
        this.cutoffTime = cutoffTime;
    }

    public List<PatientImportReport> getImportReports() {
        return importReports;
    }

    public void setImportReports(List<PatientImportReport> importReports) {
        this.importReports = importReports;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
