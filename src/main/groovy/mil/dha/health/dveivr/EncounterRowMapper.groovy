package mil.dha.health.dveivr

import org.springframework.jdbc.core.RowMapper

import java.sql.ResultSet
import java.sql.SQLException

/**
 * Created by phoehne on 9/8/16.
 *
 */
class EncounterRowMapper implements RowMapper<Encounter> {
    @Override
    Encounter mapRow(ResultSet rs, int rowNum) throws SQLException {
        Encounter encounter = new Encounter()
        encounter.referralId = rs.getInt("referral_id")
        encounter.providerId = rs.getInt("provider_id")
        encounter.sta6a = rs.getString("sta6a")
        encounter.visitDate = rs.getDate("visit_date")
        encounter.chiefComplaintText = rs.getString("chief_complaint_text")
        encounter.tbiIndicator = rs.getString("tbi_ind")
        encounter.tbiReadProblemIndicator = rs.getString("tbi_read_problem_ind")
        encounter.tbiDiplopiaIndicator = rs.getString("tbi_diplopia_imd")
        encounter.tbiDazzinglIndicator = rs.getString("tbi_dazzling_ind")
        encounter.tbiPhotophobiaIndicator = rs.getString("tbi_photophobia_ind")
        encounter.tbiOtherNeurologicalIndicator = rs.getString("other_neurological_ind")
        encounter.neurologicalCommentText = rs.getString("neurological_comment_text")
        encounter.diagnosisSummaryCommentText = rs.getString("diagnosis_summary_comment_text")
        encounter.procedureSummaryCommentText = rs.getString("procedure_summary_comment_text")
        encounter.currentlyHospitalizedIndicator = rs.getString("current_hospitalized_ind")
        encounter.tbiEyeStrainIndicator = rs.getString("tbi_eye_strain_ind")
        encounter.tbiBlurredVisionIndicator = rs.getString("tbi_blurred_vision_ind")
        encounter.primaryClinicStopDescription = rs.getString("primaryclinicstopdesc")
        encounter.primaryClinckStop = rs.getString("primaryclinicstop")
        encounter.followup = rs.getString("followup")
        encounter.duplicate = rs.getString("duplicate")
        encounter.historyOfPresentIllnessText = rs.getString("history_of_present_illness_text")
        encounter.standardMaritalStatus = rs.getString("MARITALSTATUS")
        encounter.standardServiceBranch = rs.getString("SERVICEBRANCH")
        encounter.serviceStatus = rs.getString("SERVICE_STATUS")
        encounter.occupation = rs.getString("occupation")
        encounter.jobDescription = rs.getString("job_description")
        return encounter
    }
}
