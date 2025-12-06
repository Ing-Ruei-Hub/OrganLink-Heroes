package Business.WorkQueue;

import Business.Donor.Donor;
import Business.Recipient.Recipient;
import Business.UserAccount.UserAccount;
import java.util.Date;

public class EmergencyProtocolRequest extends WorkRequest {

    private Donor donor;
    private Recipient recipient;
    private String reason;
    private String protocolType; // e.g., "Urgent Transplant", "Critical Condition"
    private boolean isApprovedByGovernment;
    private UserAccount governmentApprover;

    public EmergencyProtocolRequest(String message, UserAccount sender, UserAccount receiver, String reason, String protocolType, Donor donor, Recipient recipient) {
        super();
        setMessage(message);
        setSender(sender);
        setReceiver(receiver);
        setStatus("Pending Government Approval"); // Initial status
        this.reason = reason;
        this.protocolType = protocolType;
        this.donor = donor;
        this.recipient = recipient;
        this.isApprovedByGovernment = false;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public boolean isIsApprovedByGovernment() {
        return isApprovedByGovernment;
    }

    public void setIsApprovedByGovernment(boolean isApprovedByGovernment) {
        this.isApprovedByGovernment = isApprovedByGovernment;
    }

    public UserAccount getGovernmentApprover() {
        return governmentApprover;
    }

    public void setGovernmentApprover(UserAccount governmentApprover) {
        this.governmentApprover = governmentApprover;
    }

    @Override
    public String toString() {
        String subjectName = "";
        if (donor != null) {
            subjectName = donor.getName();
        } else if (recipient != null) {
            subjectName = recipient.getName();
        }
        return "Emergency (" + protocolType + ") for " + subjectName + " - " + getStatus();
    }
}
