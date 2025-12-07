package Business.Donor;

import Business.Medical.MedicalTestResult; // Import MedicalTestResult
import java.util.ArrayList; // Import ArrayList
import java.util.Date;
import java.util.List; // Import List

public class Donor {

    private String name;
    private String donorId;
    private Date dateOfBirth;
    private String bloodType;
    private String organToDonate;
    private String medicalHistory; // A simple string for now, could be a complex object
    private String status; // e.g., "Registered", "Approved", "Medical Tests Pending", "Compatible"
    private String contactNumber;
    private String email;
    private List<MedicalTestResult> medicalTestResultList; // New field to store test results

    private static int counter = 0;

    public Donor(String name) {
        this.name = name;
        this.donorId = "DON" + counter++;
        this.status = "Registered"; // Default status
        this.medicalTestResultList = new ArrayList<>(); // Initialize the list
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDonorId() {
        return donorId;
    }

    // DonorId should not be settable after creation
    // public void setDonorId(String donorId) { this.donorId = donorId; }

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

    public String getOrganToDonate() {
        return organToDonate;
    }

    public void setOrganToDonate(String organToDonate) {
        this.organToDonate = organToDonate;
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
    
    // New Getters and Setters for medicalTestResultList
    public List<MedicalTestResult> getMedicalTestResultList() {
        return medicalTestResultList;
    }

    public void setMedicalTestResultList(List<MedicalTestResult> medicalTestResultList) {
        this.medicalTestResultList = medicalTestResultList;
    }

    @Override
    public String toString() {
        return name;
    }
}
