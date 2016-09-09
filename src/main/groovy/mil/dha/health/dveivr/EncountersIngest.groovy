package mil.dha.health.dveivr

import com.marklogic.client.DatabaseClient
import com.marklogic.client.document.ServerTransform
import com.marklogic.client.document.XMLDocumentManager
import com.marklogic.client.eval.ServerEvaluationCall
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

    @Value('${sql.encounters}')
    String encountersSql

    @Value('${transform.xquery}')
    String xquery

    @Autowired
    JdbcTemplate jdbcTemplate

    @Autowired
    DatabaseClient databaseClient

    public loadDocument(uri, collection, doc) {
        XMLDocumentManager xmlDocumentManager = databaseClient.newXMLDocumentManager()

        DocumentMetadataHandle documentMetadataHandle = new DocumentMetadataHandle()
        documentMetadataHandle.getCollections().addAll(collection)
        documentMetadataHandle.getPermissions().add("rest-reader", DocumentMetadataHandle.Capability.READ)
        documentMetadataHandle.getPermissions().add("rest-writer", DocumentMetadataHandle.Capability.UPDATE)

        XMLWriteHandle xmlWriteHandle = new StringHandle(doc)

        xmlDocumentManager.write(uri, documentMetadataHandle, xmlWriteHandle)
    }

    public processPatient(Patient p) {
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

        loadDocument(String.format("/patients/%d.xml", p.patientId), "patient-raw", stringWriter.toString())

        ServerEvaluationCall sec = databaseClient.newServerEval()
        sec.xquery(xquery)
        sec.addVariable("uri", String.format('/patients/%s.xml', p.patientId))
        sec.eval()
    }

    public processEncounters(Encounter e) {
        StringWriter stringWriter = new StringWriter()
        MarkupBuilder markupBuilder = new MarkupBuilder(stringWriter);

        def encounter = markupBuilder.patient() {
            encounterId(e.encounterId)
            referralId(e.referralId)
            providerId(e.providerId)
            st6a(e.sta6a)
            visitDate(e.visitDate)
            chiefComplaintText(e.chiefComplaintText)
            tbiIndicator(e.tbiIndicator)
            tbiReadProblemIndicator(e.tbiReadProblemIndicator)
            tbiDiplopiaIndicator(e.tbiDiplopiaIndicator)
            tbiDazzinglIndicator(e.tbiDazzinglIndicator)
            tbiPhotophobiaIndicator(e.tbiPhotophobiaIndicator)
            tbiOtherNeurologicalIndicator(e.tbiOtherNeurologicalIndicator)
            neurologicalCommentText(e.neurologicalCommentText)
            diagnosisSummaryCommentText(e.diagnosisSummaryCommentText)
            procedureSummaryCommentText(e.procedureSummaryCommentText)
            currentlyHospitalizedIndicator(e.currentlyHospitalizedIndicator)
            tbiEyeStrainIndicator(e.tbiEyeStrainIndicator)
            tbiBlurredVisionIndicator(e.tbiBlurredVisionIndicator)
            primaryClinicStopDescription(e.primaryClinicStopDescription)
            primaryClinckStop(e.primaryClinckStop)
            followup(e.followup)
            duplicate(e.duplicate)
            historyOfPresentIllnessText(e.historyOfPresentIllnessText)
            standardMaritalStatus(e.standardMaritalStatus)
            standardServiceBranch(e.standardServiceBranch)
            serviceStatus(e.serviceStatus)
            occupation(e.occupation)
            jobDescription(e.jobDescription)
        }

        loadDocument(String.format("/encounters/%d.xml", e.encounterId), "encounter-raw", stringWriter.toString())

        ServerEvaluationCall sec = databaseClient.newServerEval()
        sec.xquery(xquery)
        sec.addVariable("uri", String.format('/encounters/%s.xml', e.encounterId))
        sec.eval()

    }

    public void run() {
        List<Patient> patients = jdbcTemplate.query(patientSql, new PatientRowMapper())
        for(Patient p : patients) {
            processPatient(p)
            List<Encounter> encounters = jdbcTemplate.query(encountersSql, [p.patientId.toString()], [String.class], new EncounterRowMapper())
            for(Encounter e : encounters) {
                processEncounters(e)
            }
        }
    }
}