
package Business.Organization;

import Business.Role.DonorRole;
import Business.Role.Role;
import java.util.ArrayList;
import Business.Donor.DonorDirectory; // Import the new DonorDirectory class

/**
 *
 * @author rrheg
 */
public class DonorOrganization extends Organization {
    
    private DonorDirectory donorDirectory; // Declare DonorDirectory
    
    public DonorOrganization() {
        super(Type.Donor.getValue());
        donorDirectory = new DonorDirectory(); // Initialize in constructor
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DonorRole());
        return roles;
    }
    
    // Getter for DonorDirectory
    public DonorDirectory getDonorDirectory() {
        if(donorDirectory == null){ // Defensive check for deserialization of old objects
            donorDirectory = new DonorDirectory();
        }
        return donorDirectory;
    }
    
}
