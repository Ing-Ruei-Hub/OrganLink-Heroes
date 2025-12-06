package Business.WorkQueue;

import Business.Donor.Donor; // Assuming Donor class exists in Business.Donor package
import Business.UserAccount.UserAccount;
import java.util.Date;

public class DonorRegistrationRequest extends WorkRequest {

    private Donor donor; // Reference to the Donor object being registered
    // Add any other specific attributes for a donor registration request

    public DonorRegistrationRequest(String message, UserAccount sender, UserAccount receiver, Donor donor) {
        super();
        setMessage(message);
        setSender(sender);
        setReceiver(receiver);
        setStatus("Pending Hospital Review"); // Initial status
        this.donor = donor;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    @Override
    public String toString() {
        return donor != null ? donor.getName() + " - " + getStatus() : super.toString();
    }
}
