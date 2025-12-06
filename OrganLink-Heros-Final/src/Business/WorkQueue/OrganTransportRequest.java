package Business.WorkQueue;

import Business.Donor.Donor;
import Business.Recipient.Recipient;
import Business.UserAccount.UserAccount;
import java.util.Date;

// Assuming TransportVehicle and LogisticsTeam classes will be created later
public class OrganTransportRequest extends WorkRequest {

    private Donor donor;
    private Recipient recipient;
    private String pickupLocation;
    private String deliveryLocation;
    private String urgency; // e.g., "Critical", "Urgent", "Standard"
    private String assignedVehicle; // ID or name of assigned vehicle
    private String assignedTeam;    // ID or name of assigned team

    public OrganTransportRequest(String message, UserAccount sender, UserAccount receiver,
                                 Donor donor, Recipient recipient,
                                 String pickupLocation, String deliveryLocation, String urgency) {
        super();
        setMessage(message);
        setSender(sender);
        setReceiver(receiver);
        setStatus("Pending Logistics Assignment"); // Initial status
        this.donor = donor;
        this.recipient = recipient;
        this.pickupLocation = pickupLocation;
        this.deliveryLocation = deliveryLocation;
        this.urgency = urgency;
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

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getAssignedVehicle() {
        return assignedVehicle;
    }

    public void setAssignedVehicle(String assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    public String getAssignedTeam() {
        return assignedTeam;
    }

    public void setAssignedTeam(String assignedTeam) {
        this.assignedTeam = assignedTeam;
    }

    @Override
    public String toString() {
        String donorName = donor != null ? donor.getName() : "N/A";
        String recipientName = recipient != null ? recipient.getName() : "N/A";
        return "Transport: " + donorName + " -> " + recipientName + " (" + urgency + ") - " + getStatus();
    }
}
