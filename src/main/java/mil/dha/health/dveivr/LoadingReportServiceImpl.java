package mil.dha.health.dveivr;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.extensions.ResourceManager;
import com.marklogic.client.extensions.ResourceServices;
import com.marklogic.client.io.*;
import com.marklogic.client.util.RequestParameters;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Service to return the latest report of loaded data.
 */
@Service("loadingReportService")
public class LoadingReportServiceImpl implements LoadingReportService {

    private DatabaseClient databaseClient;

    public LoadingReportServiceImpl(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    private ReportsManager reportsManager;

    private class ReportsManager extends ResourceManager {
        static final String NAME = "loaderReports";

        ReportsManager(DatabaseClient client) {
            super();
            client.init(NAME, this);
        }

        LoadingReport lastReport() throws IOException {
            RequestParameters requestParameters = new RequestParameters();
            requestParameters.add("service", NAME);
            String[] mimetypes = new String[] {"application/json"};

            ResourceServices services = getServices();
            ResourceServices.ServiceResultIterator resultIterator =  services.get(requestParameters, mimetypes);

            ResourceServices.ServiceResult next = resultIterator.next();
            JacksonDatabindHandle<LoadingReport> jacksonHandle = new JacksonDatabindHandle<>(LoadingReport.class);
            next.getContent(jacksonHandle);

            LoadingReport result = jacksonHandle.get();


            resultIterator.close();

            return result;
        }
    }

    @PostConstruct
    public void postConstruct() {
        reportsManager = new ReportsManager(databaseClient);
    }

    @Override
    public void saveReport(LoadingReport loadingReport) {
        JSONDocumentManager jdm = databaseClient.newJSONDocumentManager();
        JacksonDatabindHandle<LoadingReport> jacksonDatabindHandle = new JacksonDatabindHandle<>(LoadingReport.class);

        jacksonDatabindHandle.set(loadingReport);

        DocumentMetadataHandle documentMetadataHandle = new DocumentMetadataHandle();
        documentMetadataHandle.getCollections().addAll("loader-report");
        documentMetadataHandle.getPermissions().add("rest-reader", DocumentMetadataHandle.Capability.READ);
        documentMetadataHandle.getPermissions().add("rest-writer", DocumentMetadataHandle.Capability.READ, DocumentMetadataHandle.Capability.UPDATE);

        String reportUri = String.format("/loading-report/%s.json", loadingReport.getReportId().toString());

        jdm.write(reportUri, documentMetadataHandle, jacksonDatabindHandle);
    }

    @Override
    public LoadingReport lastReport() throws IOException {
        return reportsManager.lastReport();
    }
}
