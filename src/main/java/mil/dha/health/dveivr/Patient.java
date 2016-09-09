package mil.dha.health.dveivr;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by phoehne on 8/12/16.
 */
@XmlRootElement(name = "patient")
public class Patient {
    private int patientId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String oefOifInd;
    private Date birthDate;
    private Date deathDate;
    private String gender;
    private String ethnicity;
    private String maritalStatus;
    private String race;
    private String serviceBranch;
    private String zipPlusFour;
    private Date lastServiceSeparationDate;
    private Date enrollmentDate;
    private String edipn;
    private String serviceStatus;
    private String livingArrangements;
    private String unit;
    private String occupation;
    private String jobDescription;
    private String militaryStatus;
    private String category;
    private String suffix;
    private Date updated;
    private Date created;


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOefOifInd() {
        return oefOifInd;
    }

    public void setOefOifInd(String oefOifInd) {
        this.oefOifInd = oefOifInd;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getServiceBranch() {
        return serviceBranch;
    }

    public void setServiceBranch(String serviceBranch) {
        this.serviceBranch = serviceBranch;
    }

    public String getZipPlusFour() {
        return zipPlusFour;
    }

    public void setZipPlusFour(String zipPlusFour) {
        this.zipPlusFour = zipPlusFour;
    }

    public Date getLastServiceSeparationDate() {
        return lastServiceSeparationDate;
    }

    public void setLastServiceSeparationDate(Date lastServiceSeparationDate) {
        this.lastServiceSeparationDate = lastServiceSeparationDate;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getEdipn() {
        return edipn;
    }

    public void setEdipn(String edipn) {
        this.edipn = edipn;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getLivingArrangements() {
        return livingArrangements;
    }

    public void setLivingArrangements(String livingArrangements) {
        this.livingArrangements = livingArrangements;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
