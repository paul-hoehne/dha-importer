package mil.dha.health.dveivr;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * This logs what happend when trying to import patient data.
 */
public class PatientImportReport {
    private int patientId;
    private List<EncounterImportReport> encounterImportReportList;
    private boolean patientSuccess;
    private String log;

    public PatientImportReport() {
        encounterImportReportList = new LinkedList<>();
    }

    public PatientImportReport(int patientId, boolean success) {
        encounterImportReportList = new LinkedList<>();
        this.patientId = patientId;
        this.patientSuccess = success;
    }

    public PatientImportReport(int patientId, boolean success, String log) {
        encounterImportReportList = new LinkedList<>();
        this.patientId = patientId;
        this.patientSuccess = success;
        this.log = log;
    }

    public EncounterImportReport startEncounterImport(int encounterId) {
        EncounterImportReport encounterImportReport = new EncounterImportReport();
        encounterImportReport.setEncounterId(encounterId);
        encounterImportReportList.add(encounterImportReport);
        return encounterImportReport;
    }

    public void logException(Throwable t) {
        this.setPatientSuccess(false);

        StringWriter stringWriter = new StringWriter();
        stringWriter.write(t.getMessage());
        stringWriter.write("\n");

        t.printStackTrace(new PrintWriter(stringWriter));
        this.setLog(stringWriter.toString());
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public List<EncounterImportReport> getEncounterImportReportList() {
        return encounterImportReportList;
    }

    public void setEncounterImportReportList(List<EncounterImportReport> encounterImportReportList) {
        this.encounterImportReportList = encounterImportReportList;
    }

    public boolean isPatientSuccess() {
        return patientSuccess;
    }

    public void setPatientSuccess(boolean patientSuccess) {
        this.patientSuccess = patientSuccess;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
