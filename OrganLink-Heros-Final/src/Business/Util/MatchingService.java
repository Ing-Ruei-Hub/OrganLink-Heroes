package Business.Util;

import Business.Donor.Donor;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;
import Business.Recipient.Recipient;
import java.util.ArrayList;
import java.util.List;

public class MatchingService {

    public List<Donor> findCompatibleDonors(EcoSystem system, Recipient recipient) {
        List<Donor> compatibleDonors = new ArrayList<>();

        if (recipient == null || recipient.getOrganNeeded() == null || recipient.getBloodType() == null) {
            return compatibleDonors; // Cannot match without recipient info
        }

        // Iterate through all networks
        for (Network network : system.getNetworkList()) {
            // Iterate through all enterprises in each network
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                // Iterate through all organizations in each enterprise
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    // Check if the organization is a DonorOrganization
                    if (organization instanceof DonorOrganization donorOrganization) {
                        // Iterate through all donors in the DonorOrganization
                        for (Donor donor : donorOrganization.getDonorDirectory().getDonorList()) {
                            // Check for compatibility
                            // Basic compatibility: organ needed matches organ to donate and blood types match
                            
                            if (donor.getOrganToDonate() != null && donor.getOrganToDonate().equalsIgnoreCase(recipient.getOrganNeeded())) {
                                if (donor.getBloodType() != null && donor.getBloodType().equalsIgnoreCase(recipient.getBloodType())) {
                                    compatibleDonors.add(donor);
                                }
                            }
                            
                        }
                    }
                }
            }
        }
        return compatibleDonors;
    }
}