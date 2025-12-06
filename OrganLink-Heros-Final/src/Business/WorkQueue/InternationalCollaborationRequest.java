package Business.WorkQueue;

import Business.Recipient.Recipient;
import Business.UserAccount.UserAccount;
import java.util.Date;

public class InternationalCollaborationRequest extends WorkRequest {

    private Recipient recipient;
    private String organRequired; // Redundant if in Recipient, but useful for quick access
    private String bloodType;     // Redundant if in Recipient, but useful for quick access
    private boolean internationalMatchFound;
    private String internationalMatchDetails; // Details about the match if found

    public InternationalCollaborationRequest(String message, UserAccount sender, UserAccount receiver, Recipient recipient) {
        super();
        setMessage(message);
        setSender(sender);
        setReceiver(receiver);
        setStatus("Pending International Review"); // Initial status
        this.recipient = recipient;
        this.organRequired = recipient.getOrganNeeded(); // Assuming Recipient has this field
        this.bloodType = recipient.getBloodType();     // Assuming Recipient has this field
        this.internationalMatchFound = false;
    }

    // Getters and Setters
    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String getOrganRequired() {
        return organRequired;
    }

    public void setOrganRequired(String organRequired) {
        this.organRequired = organRequired;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public boolean isInternationalMatchFound() {
        return internationalMatchFound;
    }

    public void setInternationalMatchFound(boolean internationalMatchFound) {
        this.internationalMatchFound = internationalMatchFound;
    }

    public String getInternationalMatchDetails() {
        return internationalMatchDetails;
    }

    public void setInternationalMatchDetails(String internationalMatchDetails) {
        this.internationalMatchDetails = internationalMatchDetails;
    }

    @Override
    public String toString() {
        return recipient != null ? "International Request for " + recipient.getName() + " - " + getStatus() : super.toString();
    }
}
