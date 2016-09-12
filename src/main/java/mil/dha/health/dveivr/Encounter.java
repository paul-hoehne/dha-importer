package mil.dha.health.dveivr;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Encounter data from the database.
 */
@XmlRootElement(name="encounter")
public class Encounter {
    private int encounterId;
    private int patientId;
    private int referralId;
    private int providerId;
    private String sta6a;
    private Date visitDate;
    private String chiefComplaintText;
    private String tbiIndicator;
    private String tbiReadProblemIndicator;
    private String tbiDiplopiaIndicator;
    private String tbiDazzinglIndicator;
    private String tbiPhotophobiaIndicator;
    private String tbiOtherNeurologicalIndicator;
    private String neurologicalCommentText;
    private String diagnosisSummaryCommentText;
    private String procedureSummaryCommentText;
    private String currentlyHospitalizedIndicator;
    private String tbiEyeStrainIndicator;
    private String tbiBlurredVisionIndicator;
    private String primaryClinicStopDescription;
    private String primaryClinicStop;
    private String followup;
    private String duplicate;
    private String standardEncounterType;
    private String historyOfPresentIllnessText;
    private String standardMaritalStatus;
    private String standardServiceBranch;
    private String serviceStatus;
    private String standardServiceStatus;
    private String standardLivingArrangementsType;
    private String unit;
    private String occupation;
    private String jobDescription;
    private String militaryStatus;

    public int getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(int encounterId) {
        this.encounterId = encounterId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getReferralId() {
        return referralId;
    }

    public void setReferralId(int referralId) {
        this.referralId = referralId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getSta6a() {
        return sta6a;
    }

    public void setSta6a(String sta6a) {
        this.sta6a = sta6a;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getChiefComplaintText() {
        return chiefComplaintText;
    }

    public void setChiefComplaintText(String chiefComplaintText) {
        this.chiefComplaintText = chiefComplaintText;
    }

    public String getTbiIndicator() {
        return tbiIndicator;
    }

    public void setTbiIndicator(String tbiIndicator) {
        this.tbiIndicator = tbiIndicator;
    }

    public String getTbiReadProblemIndicator() {
        return tbiReadProblemIndicator;
    }

    public void setTbiReadProblemIndicator(String tbiReadProblemIndicator) {
        this.tbiReadProblemIndicator = tbiReadProblemIndicator;
    }

    public String getTbiDiplopiaIndicator() {
        return tbiDiplopiaIndicator;
    }

    public void setTbiDiplopiaIndicator(String tbiDiplopiaIndicator) {
        this.tbiDiplopiaIndicator = tbiDiplopiaIndicator;
    }

    public String getTbiDazzinglIndicator() {
        return tbiDazzinglIndicator;
    }

    public void setTbiDazzinglIndicator(String tbiDazzinglIndicator) {
        this.tbiDazzinglIndicator = tbiDazzinglIndicator;
    }

    public String getTbiPhotophobiaIndicator() {
        return tbiPhotophobiaIndicator;
    }

    public void setTbiPhotophobiaIndicator(String tbiPhotophobiaIndicator) {
        this.tbiPhotophobiaIndicator = tbiPhotophobiaIndicator;
    }

    public String getTbiOtherNeurologicalIndicator() {
        return tbiOtherNeurologicalIndicator;
    }

    public void setTbiOtherNeurologicalIndicator(String tbiOtherNeurologicalIndicator) {
        this.tbiOtherNeurologicalIndicator = tbiOtherNeurologicalIndicator;
    }

    public String getNeurologicalCommentText() {
        return neurologicalCommentText;
    }

    public void setNeurologicalCommentText(String neurologicalCommentText) {
        this.neurologicalCommentText = neurologicalCommentText;
    }

    public String getDiagnosisSummaryCommentText() {
        return diagnosisSummaryCommentText;
    }

    public void setDiagnosisSummaryCommentText(String diagnosisSummaryCommentText) {
        this.diagnosisSummaryCommentText = diagnosisSummaryCommentText;
    }

    public String getProcedureSummaryCommentText() {
        return procedureSummaryCommentText;
    }

    public void setProcedureSummaryCommentText(String procedureSummaryCommentText) {
        this.procedureSummaryCommentText = procedureSummaryCommentText;
    }

    public String getCurrentlyHospitalizedIndicator() {
        return currentlyHospitalizedIndicator;
    }

    public void setCurrentlyHospitalizedIndicator(String currentlyHospitalizedIndicator) {
        this.currentlyHospitalizedIndicator = currentlyHospitalizedIndicator;
    }

    public String getTbiEyeStrainIndicator() {
        return tbiEyeStrainIndicator;
    }

    public void setTbiEyeStrainIndicator(String tbiEyeStrainIndicator) {
        this.tbiEyeStrainIndicator = tbiEyeStrainIndicator;
    }

    public String getTbiBlurredVisionIndicator() {
        return tbiBlurredVisionIndicator;
    }

    public void setTbiBlurredVisionIndicator(String tbiBlurredVisionIndicator) {
        this.tbiBlurredVisionIndicator = tbiBlurredVisionIndicator;
    }

    public String getPrimaryClinicStopDescription() {
        return primaryClinicStopDescription;
    }

    public void setPrimaryClinicStopDescription(String primaryClinicStopDescription) {
        this.primaryClinicStopDescription = primaryClinicStopDescription;
    }

    public String getPrimaryClinicStop() {
        return primaryClinicStop;
    }

    public void setPrimaryClinicStop(String primaryClinicStop) {
        this.primaryClinicStop = primaryClinicStop;
    }

    public String getFollowup() {
        return followup;
    }

    public void setFollowup(String followup) {
        this.followup = followup;
    }

    public String getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(String duplicate) {
        this.duplicate = duplicate;
    }

    public String getStandardEncounterType() {
        return standardEncounterType;
    }

    public void setStandardEncounterType(String standardEncounterType) {
        this.standardEncounterType = standardEncounterType;
    }

    public String getHistoryOfPresentIllnessText() {
        return historyOfPresentIllnessText;
    }

    public void setHistoryOfPresentIllnessText(String historyOfPresentIllnessText) {
        this.historyOfPresentIllnessText = historyOfPresentIllnessText;
    }

    public String getStandardMaritalStatus() {
        return standardMaritalStatus;
    }

    public void setStandardMaritalStatus(String standardMaritalStatus) {
        this.standardMaritalStatus = standardMaritalStatus;
    }

    public String getStandardServiceBranch() {
        return standardServiceBranch;
    }

    public void setStandardServiceBranch(String standardServiceBranch) {
        this.standardServiceBranch = standardServiceBranch;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getStandardServiceStatus() {
        return standardServiceStatus;
    }

    public void setStandardServiceStatus(String standardServiceStatus) {
        this.standardServiceStatus = standardServiceStatus;
    }

    public String getStandardLivingArrangementsType() {
        return standardLivingArrangementsType;
    }

    public void setStandardLivingArrangementsType(String standardLivingArrangementsType) {
        this.standardLivingArrangementsType = standardLivingArrangementsType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getMilitaryStatus() {
        return militaryStatus;
    }

    public void setMilitaryStatus(String militaryStatus) {
        this.militaryStatus = militaryStatus;
    }
}
