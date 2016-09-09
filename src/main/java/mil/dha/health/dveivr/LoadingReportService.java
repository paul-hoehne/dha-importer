package mil.dha.health.dveivr;

import java.io.IOException;

/**
 * This is a service to manage loading reports
 */
public interface LoadingReportService {
    void saveReport(LoadingReport report);
    LoadingReport lastReport() throws IOException;
}