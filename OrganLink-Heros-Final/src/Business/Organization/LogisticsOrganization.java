
package Business.Organization;

import Business.Role.LogisticsRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class LogisticsOrganization extends Organization {
    
    public LogisticsOrganization() {
        super(Type.Logistics.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LogisticsRole());
        return roles;
    }
    
}
