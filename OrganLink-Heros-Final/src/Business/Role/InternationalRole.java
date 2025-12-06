
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.InternationalOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author rrheg
 */
public class InternationalRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //return new InternationalWorkAreaJPanel(userProcessContainer, account, (InternationalOrganization)organization, enterprise);
        return new JPanel();
    }
    
}
