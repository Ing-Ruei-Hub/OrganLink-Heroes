package Business.Donor;

import Business.Medical.MedicalTestResult;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Donor {

    private String name;
    private String donorId;
    private Date dateOfBirth;
    private String bloodType;
    private String organToDonate;
    private String medicalHistory;
    private String status;
    private String contactNumber;
    private String email;
    private int age;
    private List<MedicalTestResult> medicalTestResultList;
    private UserAccount userAccount;

    private static int counter = 0;

    public Donor(String name) {
        this.name = name;
        this.donorId = "DON" + counter++;
        this.status = "Registered";
        this.medicalTestResultList = new ArrayList<>();
    }
    
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    /**
 * Synchronize the counter based on existing Donor IDs.
 * Call this method after loading data from database.
 * @param existingId the existing donor ID (e.g., "DON5")
 */
public static void syncCounter(String existingId) {
    if (existingId != null && existingId.startsWith("DON")) {
        try {
            int idNumber = Integer.parseInt(existingId.substring(3));
            if (idNumber >= counter) {
                counter = idNumber + 1;
            }
        } catch (NumberFormatException e) {
            // Ignore invalid ID format
        }
    }
}

/**
 * Get current counter value (for debugging)
 */
public static int getCounter() {
    return counter;
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
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
