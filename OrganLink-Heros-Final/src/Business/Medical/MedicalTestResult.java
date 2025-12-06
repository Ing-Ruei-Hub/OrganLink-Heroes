package Business.Medical;

import Business.Donor.Donor;
import Business.Recipient.Recipient;
import Business.UserAccount.UserAccount;
import java.util.Date;

public class MedicalTestResult {

    private String testName;
    private String resultDetails; // e.g., "Blood Type A+, Tissue Match 6/6"
    private String filePath; // Optional: path to an uploaded document
    private Date testDate;
    private boolean isVerified;
    private UserAccount verifiedBy; // Doctor or LabTech who verified/uploaded
    private Donor donor; // Can be null if for recipient
    private Recipient recipient; // Can be null if for donor

    public MedicalTestResult(String testName, Donor donor, Recipient recipient) {
        this.testName = testName;
        this.donor = donor;
        this.recipient = recipient;
        this.testDate = new Date();
        this.isVerified = false;
    }

    // Getters and Setters
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getResultDetails() {
        return resultDetails;
    }

    public void setResultDetails(String resultDetails) {
        this.resultDetails = resultDetails;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public UserAccount getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(UserAccount verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        String subject = "";
        if (donor != null) {
            subject = "Donor: " + donor.getName();
        } else if (recipient != null) {
            subject = "Recipient: " + recipient.getName();
        }
        return testName + " for " + subject + " - " + (isVerified ? "Verified" : "Pending Verification");
    }
}
