package mil.dha.health.dveivr;


import java.util.LinkedList;
import java.util.List;

/**
 * This logs what happend when trying to import patient data.
 */
class PatientImportReport {
    private String patientId;
    private List<EncounterImportReport> encounterImportReportList;
    private boolean patientSuccess;
    private String log;

    public PatientImportReport() {
        encounterImportReportList = new LinkedList<>();
    }

    public PatientImportReport(String patientId, boolean success) {
        encounterImportReportList = new LinkedList<>();
        this.patientId = patientId;
        this.patientSuccess = success;
    }

    public PatientImportReport(String patientId, boolean success, String log) {
        encounterImportReportList = new LinkedList<>();
        this.patientId = patientId;
        this.patientSuccess = success;
        this.log = log;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
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
