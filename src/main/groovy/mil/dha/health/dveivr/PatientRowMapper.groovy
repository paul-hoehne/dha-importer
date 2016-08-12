package mil.dha.health.dveivr

import org.springframework.jdbc.core.RowMapper

import java.sql.ResultSet
import java.sql.SQLException

/**
 * Map patient source query to fields in patient object
 *
 */
class PatientRowMapper implements RowMapper<Patient> {

    @Override
    Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Patient patient = new Patient()
        patient.patientId = rs.getInt("patient_id")
        patient.firstName = rs.getString("first_name")
        patient.lastName = rs.getString("last_name")
        patient.middleName = rs.getString("middle_name")
        patient.oefOifInd = rs.getString("oef_oif_ind")
        patient.birthDate = rs.getDate("birth_date")
        patient.deathDate = rs.getDate("death_date")
        patient.gender = rs.getString("GENDER")
        patient.ethnicity = rs.getString("ETHNICITY")
        patient.maritalStatus = rs.getString("MARITALSTATUS")
        patient.race = rs.getString("RACE")
        patient.serviceBranch = rs.getString("SERVICEBRANCH")
        patient.zipPlusFour = rs.getString("zip_plus_4")
        patient.lastServiceSeparationDate = rs.getDate("lastserviceseparationdate")
        patient.enrollmentDate = rs.getDate("enrollment_date")
        patient.edipn = rs.getString("edipn")
        patient.serviceStatus = rs.getString("SERVICE_STATUS")
        patient.livingArrangements = rs.getString("LIVING_ARRANGEMENTS")
        patient.unit = rs.getString("unit")
        patient.occupation = rs.getString("occupation")
        patient.jobDescription = rs.getString("job_description")
        patient.militaryStatus = rs.getString("MILITARY_STATUS")
        patient.category = rs.getString("CATEGORY")
        patient.suffix = rs.getString("suffix")
        return patient
    }
}
