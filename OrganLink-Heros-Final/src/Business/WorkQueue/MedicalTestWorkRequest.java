package Business.WorkQueue;

import Business.Donor.Donor;
import Business.Recipient.Recipient;
import Business.UserAccount.UserAccount;
import java.util.Date;
// Assuming MedicalTestResult class will be created later

public class MedicalTestWorkRequest extends WorkRequest {

    private Donor donor;
    private Recipient recipient;
    private String testType;
    private String testResult; // Simple string for result, can be a class later
    private boolean isVerified;
    private UserAccount verifier; // Doctor who verified

    public MedicalTestWorkRequest(String message, UserAccount sender, UserAccount receiver, String testType, Donor donor, Recipient recipient) {
        super();
        setMessage(message);
        setSender(sender);
        setReceiver(receiver);
        setStatus("Tests Requested"); // Initial status
        this.testType = testType;
        this.donor = donor;
        this.recipient = recipient;
        this.isVerified = false;
    }

    // Getters and Setters
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

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public UserAccount getVerifier() {
        return verifier;
    }

    public void setVerifier(UserAccount verifier) {
        this.verifier = verifier;
    }

    @Override
    public String toString() {
        return getStatus();
    }
}
