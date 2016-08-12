package mil.dha.health.dveivr

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
            XmlUtil.serialize(p, fileWriter)
        }
    }
}