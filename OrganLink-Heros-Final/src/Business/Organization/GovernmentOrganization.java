
package Business.Organization;

import Business.Role.GovernmentRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class GovernmentOrganization extends Organization{
    
    public GovernmentOrganization() {
        super(Type.Government.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GovernmentRole());
        return roles;
    }
    
}
