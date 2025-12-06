
package Business.Organization;

import Business.Role.HospitalOfficerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class HospitalOfficerOrganization extends Organization {

     public HospitalOfficerOrganization() {
        super(Type.HospitalOfficer.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new HospitalOfficerRole());
        return roles;
    }
    
}
