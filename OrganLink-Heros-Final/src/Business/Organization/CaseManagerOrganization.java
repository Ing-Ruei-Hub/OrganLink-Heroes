
package Business.Organization;

import Business.Role.CaseManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class CaseManagerOrganization extends Organization {
    
    public CaseManagerOrganization() {
        super(Type.CaseManager.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CaseManagerRole());
        return roles;
    }
    
}
