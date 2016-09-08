package mil.dha.health.dveivr;

/**
 * This is the result of importing encounter information.
 */
class EncounterImportReport {
    private String encounterId;
    private boolean success;
    private String log;

    public String getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(String encounterId) {
        this.encounterId = encounterId;
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
