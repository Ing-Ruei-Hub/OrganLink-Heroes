
package Business.Organization;

import Business.Role.Role;
import Business.Role.TransplantCoordinatorRole;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class TransplantCoordinatorOrganization extends Organization{
    
     public TransplantCoordinatorOrganization() {
        super(Type.TransplantCoordinator.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new TransplantCoordinatorRole());
        return roles;
    }
    
}
