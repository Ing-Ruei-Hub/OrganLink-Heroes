
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.GovernmentOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author rrheg
 */
public class GovernmentRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //return new GovernmentWorkAreaJPanel(userProcessContainer, account, (GovernmentOrganization)organization, enterprise);
        return new JPanel();
    }
    
}
