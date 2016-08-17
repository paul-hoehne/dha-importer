package mil.dha.health.dveivr

import groovy.xml.MarkupBuilder
import groovy.xml.XmlUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

import javax.sql.DataSource


@Component("encountersIngest")
public class EncountersIngest {

    @Value('${sql.patients}')
    String patientSql

    @Autowired
    JdbcTemplate jdbcTemplate

    public void run() {
        List<Patient> patients = jdbcTemplate.query(patientSql, new PatientRowMapper())
        for(Patient p : patients) {
            FileWriter fileWriter = new FileWriter(String.format("patient%d.xml", p.patientId))

            MarkupBuilder markupBuilder = new MarkupBuilder(fileWriter);

            def patient = markupBuilder.patient()
            patient.patientId(p.patientId)
            patient.firstName(p.firstName)
            patient.lastName(p.lastName)
            patient.middleName(p.middleName)
            patient.oefOifInd(p.oefOifInd)
            patient.birthDate(p.birthDate)
            patient.deathDate(p.deathDate)
            patient.gender(p.gender)
            patient.ethnicity(p.ethnicity)
            patient.maritalStatus(p.maritalStatus)
            patient.race(p.race)
            patient.serviceBranch(p.serviceBranch)
            patient.zipPlusFour(p.zipPlusFour)
            patient.lastServiceSeparationDate(p.lastServiceSeparationDate)
            patient.enrollmentDate(p.enrollmentDate)
            patient.edipn(p.edipn)
            patient.serviceStatus(p.serviceStatus)
            patient.livingArrangements(p.livingArrangements)
            patient.unit(p.unit)
            patient.occupation(p.occupation)
            patient.jobDescription(p.jobDescription)
            patient.militaryStatus(p.militaryStatus)
            patient.category(p.category)
            patient.suffix(p.suffix)
            fileWriter.flush()
            fileWriter.close()
        }
    }
}