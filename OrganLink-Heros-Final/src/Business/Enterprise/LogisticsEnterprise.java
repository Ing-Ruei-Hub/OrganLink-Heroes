
package Business.Enterprise;

import Business.Role.LogisticsRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author eric
 */
public class LogisticsEnterprise extends Enterprise{
    
    public LogisticsEnterprise(String name) {
        super(name, EnterpriseType.Logistics);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LogisticsRole());
        return roles;
    }
}
