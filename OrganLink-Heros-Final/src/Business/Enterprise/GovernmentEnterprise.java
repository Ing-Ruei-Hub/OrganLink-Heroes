
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class GovernmentEnterprise extends Enterprise{
    
    public GovernmentEnterprise(String name) {
        super(name, EnterpriseType.Government);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
