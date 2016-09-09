package mil.dha.health.dveivr;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps an encounter SQL Result to an encounter document.
 */
public class EncounterRowMapper implements RowMapper<Encounter> {
    @Override
    public Encounter mapRow(ResultSet rs, int rowNum) throws SQLException {
        Encounter encounter = new Encounter();

        encounter.setReferralId(rs.getInt("referral_id"));
        encounter.setProviderId(rs.getInt("provider_id"));
        encounter.setSta6a(rs.getString("sta6a"));
        encounter.setVisitDate(rs.getDate("visit_date"));
        encounter.setChiefComplaintText(rs.getString("chief_complaint_text"));
        encounter.setTbiIndicator(rs.getString("tbi_ind"));
        encounter.setTbiReadProblemIndicator(rs.getString("tbi_read_problem_ind"));
        encounter.setTbiDiplopiaIndicator(rs.getString("tbi_diplopia_imd"));
        encounter.setTbiDazzinglIndicator(rs.getString("tbi_dazzling_ind"));
        encounter.setTbiPhotophobiaIndicator(rs.getString("tbi_photophobia_ind"));
        encounter.setTbiOtherNeurologicalIndicator(rs.getString("other_neurological_ind"));
        encounter.setNeurologicalCommentText(rs.getString("neurological_comment_text"));
        encounter.setDiagnosisSummaryCommentText(rs.getString("diagnosis_summary_comment_text"));
        encounter.setProcedureSummaryCommentText(rs.getString("procedure_summary_comment_text"));
        encounter.setCurrentlyHospitalizedIndicator(rs.getString("current_hospitalized_ind"));
        encounter.setTbiEyeStrainIndicator(rs.getString("tbi_eye_strain_ind"));
        encounter.setTbiBlurredVisionIndicator(rs.getString("tbi_blurred_vision_ind"));
        encounter.setPrimaryClinicStopDescription(rs.getString("primaryclinicstopdesc"));
        encounter.setPrimaryClinckStop(rs.getString("primaryclinicstop"));
        encounter.setFollowup(rs.getString("followup"));
        encounter.setDuplicate(rs.getString("duplicate"));
        encounter.setHistoryOfPresentIllnessText(rs.getString("history_of_present_illness_text"));
        encounter.setStandardMaritalStatus(rs.getString("MARITALSTATUS"));
        encounter.setStandardServiceBranch(rs.getString("SERVICEBRANCH"));
        encounter.setServiceStatus(rs.getString("SERVICE_STATUS"));
        encounter.setOccupation(rs.getString("occupation"));
        encounter.setJobDescription(rs.getString("job_description"));

        return encounter;
    }
}
