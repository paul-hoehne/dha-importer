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

            fileWriter.flush()
            fileWriter.close()
        }
    }
}