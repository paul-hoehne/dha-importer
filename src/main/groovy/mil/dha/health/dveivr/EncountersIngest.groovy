package mil.dha.health.dveivr

import com.marklogic.client.DatabaseClient
import com.marklogic.client.document.XMLDocumentManager
import com.marklogic.client.io.DocumentMetadataHandle
import com.marklogic.client.io.StringHandle
import com.marklogic.client.io.marker.XMLWriteHandle
import groovy.xml.MarkupBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component("encountersIngest")
public class EncountersIngest {

    @Value('${sql.patients}')
    String patientSql

    @Autowired
    JdbcTemplate jdbcTemplate

    @Autowired
    DatabaseClient databaseClient

    public void run() {
        List<Patient> patients = jdbcTemplate.query(patientSql, new PatientRowMapper())
        for(Patient p : patients) {
            StringWriter stringWriter = new StringWriter()

            MarkupBuilder markupBuilder = new MarkupBuilder(stringWriter);

            def patient = markupBuilder.patient() {
                patientId(p.patientId.toString())
                firstName(p.firstName)
                lastName(p.lastName)
                middleName(p.middleName)
                oefOifInd(p.oefOifInd)
                birthDate(p.birthDate)
                deathDate(p.deathDate)
                gender(p.gender)
                ethnicity(p.ethnicity)
                maritalStatus(p.maritalStatus)
                race(p.race)
                serviceBranch(p.serviceBranch)
                zipPlusFour(p.zipPlusFour)
                lastServiceSeparationDate(p.lastServiceSeparationDate)
                enrollmentDate(p.enrollmentDate)
                edipn(p.edipn)
                serviceStatus(p.serviceStatus)
                livingArrangements(p.livingArrangements)
                unit(p.unit)
                occupation(p.occupation)
                jobDescription(p.jobDescription)
                militaryStatus(p.militaryStatus)
                category(p.category)
                suffix(p.suffix)
            }

            XMLDocumentManager xmlDocumentManager = databaseClient.newXMLDocumentManager()

            DocumentMetadataHandle documentMetadataHandle = new DocumentMetadataHandle()
            documentMetadataHandle.getCollections().addAll("patient")
            documentMetadataHandle.getPermissions().add("rest-reader", DocumentMetadataHandle.Capability.READ)
            documentMetadataHandle.getPermissions().add("rest-writer", DocumentMetadataHandle.Capability.UPDATE)

            XMLWriteHandle xmlWriteHandle = new StringHandle(stringWriter.toString())

            xmlDocumentManager.write(
                    String.format("/patients/{0}.xml", p.patientId),
                    documentMetadataHandle,
                    xmlWriteHandle
            )
        }
    }
}