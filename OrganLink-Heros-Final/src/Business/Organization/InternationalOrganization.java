
package Business.Organization;

import Business.Role.InternationalRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class InternationalOrganization extends Organization {
    
    public InternationalOrganization() {
        super(Type.International.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InternationalRole());
        return roles;
    }
    
}
