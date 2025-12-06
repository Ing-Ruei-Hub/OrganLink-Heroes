
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class InternationalEnterprise extends Enterprise {
    
    public InternationalEnterprise(String name) {
        super(name, EnterpriseType.International);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
