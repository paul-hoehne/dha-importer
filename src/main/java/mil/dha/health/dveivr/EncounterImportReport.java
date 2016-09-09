package mil.dha.health.dveivr;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * This is the result of importing encounter information.
 */
public class EncounterImportReport {
    private int encounterId;
    private boolean success;
    private String log;

    public EncounterImportReport() {

    }

    public EncounterImportReport(int encounterId, boolean success) {
        this.encounterId = encounterId;
        this.success = success;
    }

    public EncounterImportReport(int encounterId, boolean success, String log) {
        this.encounterId = encounterId;
        this.success = success;
        this.log = log;
    }

    public void logException(Throwable t) {
        this.setSuccess(false);

        StringWriter stringWriter = new StringWriter();
        stringWriter.write(t.getMessage());
        stringWriter.write("\n");

        t.printStackTrace(new PrintWriter(stringWriter));
        this.setLog(stringWriter.toString());
    }

    public int getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(int encounterId) {
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
