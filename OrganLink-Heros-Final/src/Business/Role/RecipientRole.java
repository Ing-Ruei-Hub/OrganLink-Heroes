
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network; // Added import for Network
import Business.Organization.Organization;
import Business.Organization.RecipientOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.RecipientRole.RecipientWorkAreaJPanel;

/**
 *
 * @author eric
 */
public class RecipientRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new RecipientWorkAreaJPanel(userProcessContainer, account, 
                (RecipientOrganization) organization, enterprise, network, business);
    }
    
    
    @Override
    public String toString() {
        return RoleType.Recipient.getValue();
    }
    
}
