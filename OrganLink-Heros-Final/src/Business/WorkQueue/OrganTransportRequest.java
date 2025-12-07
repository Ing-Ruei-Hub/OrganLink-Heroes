package Business.WorkQueue;

import Business.Donor.Donor;
import Business.Recipient.Recipient;
import java.util.Date;

public class OrganTransportRequest extends WorkRequest {
    
    private Donor donor;
    private Recipient recipient;
    private String pickupLocation;
    private String deliveryLocation;
    private String urgency; // e.g., "High", "Medium", "Low"
    private String assignedVehicle; // ID or name of the assigned vehicle
    private String assignedTeam;    // Name of the assigned logistics team

    public OrganTransportRequest(Donor donor, Recipient recipient, String pickupLocation, String deliveryLocation, String urgency) {
        super(); // Call constructor of WorkRequest
        this.donor = donor;
        this.recipient = recipient;
        this.pickupLocation = pickupLocation;
        this.deliveryLocation = deliveryLocation;
        this.urgency = urgency;
        this.setStatus("Pending Logistics Assignment"); // Initial status
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
        return "Organ Transport Request for " + donor.getName() + " -> " + recipient.getName() + " (Status: " + getStatus() + ")";
    }
}