
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.RecipientOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author rrheg
 */
public class RecipientRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //return new RecipientWorkAreaJPanel(userProcessContainer, account, (RecipientOrganization)organization, enterprise);
        return new JPanel();
    }
    
}
