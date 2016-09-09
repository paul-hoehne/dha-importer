package mil.dha.health.dveivr;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Map patient source query to fields in patient object
 */
public class PatientRowMapper implements RowMapper<Patient> {

    @Override
    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Patient patient = new Patient();

        patient.setPatientId(rs.getInt("patient_id"));
        patient.setFirstName(rs.getString("first_name"));
        patient.setLastName(rs.getString("last_name"));
        patient.setMiddleName(rs.getString("middle_name"));
        patient.setOefOifInd(rs.getString("oef_oif_ind"));
        patient.setBirthDate(rs.getDate("birth_date"));
        patient.setDeathDate(rs.getDate("death_date"));
        patient.setGender(rs.getString("GENDER"));
        patient.setEthnicity(rs.getString("ETHNICITY"));
        patient.setMaritalStatus(rs.getString("MARITALSTATUS"));
        patient.setRace(rs.getString("RACE"));
        patient.setServiceBranch(rs.getString("SERVICEBRANCH"));
        patient.setZipPlusFour(rs.getString("zip_plus_4"));
        patient.setLastServiceSeparationDate(rs.getDate("lastserviceseparationdate"));
        patient.setEnrollmentDate(rs.getDate("enrollment_date"));
        patient.setEdipn(rs.getString("edipn"));
        patient.setServiceStatus(rs.getString("SERVICE_STATUS"));
        patient.setLivingArrangements(rs.getString("LIVING_ARANGEMENTS"));
        patient.setUnit(rs.getString("unit"));
        patient.setOccupation(rs.getString("occupation"));
        patient.setJobDescription(rs.getString("job_description"));
        patient.setMilitaryStatus(rs.getString("MILITARY_STATUS"));
        patient.setCategory(rs.getString("CATEGORY"));
        patient.setSuffix(rs.getString("suffix"));
        patient.setUpdated(rs.getDate("updated"));
        patient.setCreated(rs.getDate("created"));

        return patient;
    }
}
