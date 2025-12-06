
package Business.Organization;

import Business.Role.RecipientRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class RecipientOrganization extends Organization{
    
    public RecipientOrganization() {
        super(Type.Recipient.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new RecipientRole());
        return roles;
    }
    
}
