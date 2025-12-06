package Business.WorkQueue;

import Business.Recipient.Recipient; // Reference to the Recipient object
import Business.UserAccount.UserAccount;
import java.util.Date;

public class RecipientOrganRequest extends WorkRequest {

    private Recipient recipient; // Reference to the Recipient object for this request
    private String organNeeded; // Redundant if in Recipient, but useful for quick access
    private String bloodType;   // Redundant if in Recipient, but useful for quick access

    public RecipientOrganRequest(String message, UserAccount sender, UserAccount receiver, Recipient recipient) {
        super();
        setMessage(message);
        setSender(sender);
        setReceiver(receiver);
        setStatus("Pending Coordinator Review"); // Initial status for recipient request
        this.recipient = recipient;
        this.organNeeded = recipient.getOrganNeeded(); // Assuming Recipient has this field
        this.bloodType = recipient.getBloodType();     // Assuming Recipient has this field
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String getOrganNeeded() {
        return organNeeded;
    }

    public void setOrganNeeded(String organNeeded) {
        this.organNeeded = organNeeded;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return recipient != null ? recipient.getName() + " - " + getStatus() : super.toString();
    }
}
