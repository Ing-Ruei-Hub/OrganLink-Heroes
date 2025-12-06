package Business.Recipient;

import java.util.Date;

public class Recipient {

    private String name;
    private String recipientId;
    private Date dateOfBirth;
    private String bloodType;
    private String organNeeded;
    private String medicalHistory; // A simple string for now, could be a complex object
    private String status; // e.g., "Registered", "Pending Coordinator Review", "Initial Match Found"
    private String urgencyLevel; // e.g., "High", "Medium", "Low"
    private String contactNumber;
    private String email;

    private static int counter = 0;

    public Recipient(String name) {
        this.name = name;
        this.recipientId = "REC" + counter++;
        this.status = "Registered"; // Default status
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getOrganNeeded() {
        return organNeeded;
    }

    public void setOrganNeeded(String organNeeded) {
        this.organNeeded = organNeeded;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name;
    }
}
