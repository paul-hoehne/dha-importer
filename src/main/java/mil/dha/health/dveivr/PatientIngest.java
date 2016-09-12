package mil.dha.health.dveivr;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.JAXBHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.xml.bind.*;
import java.sql.Types;
import java.util.List;

@Component("patientIngest")
public class PatientIngest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${sql.patients}")
    private String patientSql;

    @Value("${sql.encounters}")
    private String encountersSql;

    @Value("${transform.xquery}")
    private String xquery;

    private LoadingReportService loadingReportService;
    private JdbcTemplate jdbcTemplate;
    private DatabaseClient databaseClient;

    public PatientIngest(DatabaseClient databaseClient, JdbcTemplate jdbcTemplate, LoadingReportService loadingReportService) {
        Assert.notNull(databaseClient);
        Assert.notNull(jdbcTemplate);
        Assert.notNull(loadingReportService);

        this.databaseClient = databaseClient;
        this.jdbcTemplate = jdbcTemplate;
        this.loadingReportService = loadingReportService;
    }

    private <T> void loadDocument(String uri, String collection, T item, Class<T> inputClass) throws JAXBException {
        XMLDocumentManager xmlDocumentManager = databaseClient.newXMLDocumentManager();

        DocumentMetadataHandle documentMetadataHandle = new DocumentMetadataHandle();
        documentMetadataHandle.getCollections().addAll(collection);
        documentMetadataHandle.getPermissions().add("rest-reader", DocumentMetadataHandle.Capability.READ);
        documentMetadataHandle.getPermissions().add("rest-writer", DocumentMetadataHandle.Capability.UPDATE);

        JAXBHandle<T> jaxbHandle = new JAXBHandle<>(JAXBContext.newInstance(inputClass));
        jaxbHandle.set(item);

        xmlDocumentManager.write(uri, documentMetadataHandle, jaxbHandle);
    }

    private void processPatient(Patient p) throws JAXBException {
        String uri = String.format("/patients/raw/%d.xml", p.getPatientId());
        loadDocument(uri, "patient-raw", p, Patient.class);
    }

    private  void processEncounter(Encounter e) throws JAXBException {
        String uri = String.format("/encounters/raw/%d.xml", e.getEncounterId());
        loadDocument(uri, "encounter-raw", e, Encounter.class);
    }

    public void run() {
        LoadingReport loadingReport = new LoadingReport();

        List<Patient> patients = jdbcTemplate.query(patientSql, new PatientRowMapper());
        for(Patient p : patients) {
            PatientImportReport patientImportReport = loadingReport.startPatient(p.getPatientId());

            try {
                processPatient(p);

                Object[] parameters = new Object[]{ p.getPatientId() };
                int[] types = new int[]{ Types.INTEGER };

                try {
                    List<Encounter> encounters = jdbcTemplate.query(encountersSql, parameters, types, new EncounterRowMapper());
                    for (Encounter e : encounters) {
                        e.setPatientId(p.getPatientId());
                        EncounterImportReport encounterImportReport = patientImportReport.startEncounterImport(e.getEncounterId());

                        try {
                            processEncounter(e);
                            encounterImportReport.setSuccess(true);
                        } catch(Throwable t) {
                            log.warn(t.getMessage(), t);
                            encounterImportReport.logException(t);
                        }
                    }
                } catch(Throwable t) {
                    log.warn(t.getMessage(), t);
                    patientImportReport.logException(t);
                }

                loadingReport.setCutoffTime(p.getUpdated());
                patientImportReport.setPatientSuccess(true);
            } catch(Throwable t) {
                log.warn(t.getMessage(), t);
                patientImportReport.logException(t);
            }
        }

        loadingReportService.saveReport(loadingReport);
    }
}