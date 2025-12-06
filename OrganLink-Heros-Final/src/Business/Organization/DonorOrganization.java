
package Business.Organization;

import Business.Role.DonorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class DonorOrganization extends Organization {
    
     public DonorOrganization() {
        super(Type.Donor.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DonorRole());
        return roles;
    }
    
}
