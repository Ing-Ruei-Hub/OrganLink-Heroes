
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.TransplantCoordinatorOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author rrheg
 */
public class TransplantCoordinatorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //return new TransplantCoordinatorWorkAreaJPanel(userProcessContainer, account, (TransplantCoordinatorOrganization)organization, enterprise);
        return new JPanel();
    }
    
}
