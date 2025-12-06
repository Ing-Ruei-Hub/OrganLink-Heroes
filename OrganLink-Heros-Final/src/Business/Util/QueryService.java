package Business.Util;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Donor.Donor;
import Business.Recipient.Recipient;
import Business.WorkQueue.WorkRequest;
import Business.UserAccount.UserAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QueryService {

    // --- Placeholder Methods for Donors/Recipients (will need to be updated once storage is defined) ---
    // These methods assume Donors/Recipients are stored in specific directories within organizations or the EcoSystem.
    // For now, they return empty lists or a very basic placeholder logic.

    public static List<Donor> findAllDonors(EcoSystem system) {
        // This method would traverse the EcoSystem to find all Donor objects.
        // Actual implementation depends on where Donor objects are stored (e.g., within a DonorDirectory in DonorOrganization).
        // For demonstration, returning a simple list.
        return new ArrayList<>(); // Placeholder for now
    }

    public static List<Recipient> findAllRecipients(EcoSystem system) {
        // This method would traverse the EcoSystem to find all Recipient objects.
        // Actual implementation depends on where Recipient objects are stored (e.g., within a RecipientDirectory in RecipientOrganization).
        return new ArrayList<>(); // Placeholder for now
    }

    // --- WorkRequest Query Methods ---

    public static List<WorkRequest> findAllWorkRequests(EcoSystem system) {
        List<WorkRequest> allRequests = new ArrayList<>();
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    allRequests.addAll(organization.getWorkQueue().getWorkRequestList());
                }
            }
        }
        return allRequests;
    }

    public static List<WorkRequest> findWorkRequestsByStatus(EcoSystem system, String status) {
        return findAllWorkRequests(system).stream()
                .filter(request -> request.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public static List<WorkRequest> findWorkRequestsByReceiver(EcoSystem system, UserAccount receiver) {
        return findAllWorkRequests(system).stream()
                .filter(request -> request.getReceiver() != null && request.getReceiver().equals(receiver))
                .collect(Collectors.toList());
    }

    public static List<WorkRequest> findWorkRequestsBySender(EcoSystem system, UserAccount sender) {
        return findAllWorkRequests(system).stream()
                .filter(request -> request.getSender() != null && request.getSender().equals(sender))
                .collect(Collectors.toList());
    }
    
    // Additional query methods can be added as needed.
}
