package mil.dha.health.dveivr;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.eval.ServerEvaluationCall;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.JAXBHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.xml.bind.*;
import java.sql.Types;
import java.util.List;

@Component("encountersIngest")
public class EncountersIngest {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${sql.patients}")
    String patientSql;

    @Value("${sql.encounters}")
    String encountersSql;

    @Value("${transform.xquery}")
    String xquery;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DatabaseClient databaseClient;

    public <T> void loadDocument(String uri, String collection, T item, Class<T> inputClass) throws JAXBException {
        XMLDocumentManager xmlDocumentManager = databaseClient.newXMLDocumentManager();

        DocumentMetadataHandle documentMetadataHandle = new DocumentMetadataHandle();
        documentMetadataHandle.getCollections().addAll(collection);
        documentMetadataHandle.getPermissions().add("rest-reader", DocumentMetadataHandle.Capability.READ);
        documentMetadataHandle.getPermissions().add("rest-writer", DocumentMetadataHandle.Capability.UPDATE);

        JAXBHandle<T> jaxbHandle = new JAXBHandle<T>(JAXBContext.newInstance(inputClass));
        jaxbHandle.set(item);

        xmlDocumentManager.write(uri, documentMetadataHandle, jaxbHandle);
    }

    public void processPatient(Patient p) throws JAXBException {
        String uri = String.format("/patients/%d.xml", p.getPatientId());
        loadDocument(uri, "patient-raw", p, Patient.class);

        ServerEvaluationCall sec = databaseClient.newServerEval();
        sec.xquery(xquery);
        sec.addVariable("uri", String.format("/patients/%d.xml", p.getPatientId()));
        sec.eval();
    }

    public void processEncounter(Encounter e) throws JAXBException {
        String uri = String.format("/encounters/%d.xml", e.getEncounterId());
        loadDocument(uri, "encounter-raw", e, Encounter.class);

        ServerEvaluationCall sec = databaseClient.newServerEval();
        sec.xquery(xquery);
        sec.addVariable("uri", String.format("/encounters/%d.xml", e.getEncounterId()));
        sec.eval();

    }

    public void run() {
        List<Patient> patients = jdbcTemplate.query(patientSql, new PatientRowMapper());
        for(Patient p : patients) {
            try {
                processPatient(p);
                Object[] parameters = new Object[]{ p.getPatientId() };
                int[] types = new int[]{ Types.INTEGER };

                try {
                    List<Encounter> encounters = jdbcTemplate.query(encountersSql, parameters, types, new EncounterRowMapper());
                    for (Encounter e : encounters) {
                        processEncounter(e);
                    }
                } catch(Throwable t) {
                    log.warn(t.getMessage(), t);
                }
            } catch(Throwable t) {
                log.warn(t.getMessage(), t);
            }
        }
    }
}